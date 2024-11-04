package com.app.java.grabfoodappproject.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.app.java.grabfoodappproject.data.model.Food;
import com.app.java.grabfoodappproject.data.model.FoodList;
import com.app.java.grabfoodappproject.data.remote.Result;
import com.app.java.grabfoodappproject.data.repository.Repository;

import java.util.List;

public class FoodListViewModel extends ViewModel {
    private final Repository mRepository;
    private final MutableLiveData<List<Food>> _foods;
    public LiveData<List<Food>> foods;

    public FoodListViewModel(Repository repository) {
        mRepository = repository;
        _foods = new MutableLiveData<>();
        this.foods = _foods;
        loadFoods();
    }

    public void loadFoods() {
        mRepository.makeGetFoodRequest(result -> {
            if (result instanceof Result.Success) {
                _foods.postValue(((Result.Success<FoodList>) result).data.getFoods());
            } else {
                _foods.postValue(null);
            }
        });

    }
}
