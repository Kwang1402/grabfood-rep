package com.app.java.grabfoodappproject.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.app.java.grabfoodappproject.data.model.Ad;
import com.app.java.grabfoodappproject.data.model.AdList;
import com.app.java.grabfoodappproject.data.remote_datasource.Result;
import com.app.java.grabfoodappproject.data.repository.Repository;

import java.util.List;

public class AdListViewModel extends ViewModel {
    private final Repository mRepository;
    private final MutableLiveData<List<Ad>> _ads;
    public LiveData<List<Ad>> ads;

    public AdListViewModel(Repository repository){
        mRepository = repository;
        _ads = new MutableLiveData<>();
        this.ads = _ads;
        loadAds();
    }

    /**
     * result is implementation of RepositoryCallback, specifically implement onComplete() method)
     */
    private void loadAds() {
        mRepository.makeGetAdRequest(result -> {
            if(result instanceof Result.Success){
                _ads.postValue(((Result.Success<AdList>) result).data.getAdLists());
            }else{
                _ads.postValue(null);
            }
        });
    }
}
