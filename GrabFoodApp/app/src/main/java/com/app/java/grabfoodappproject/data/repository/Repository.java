package com.app.java.grabfoodappproject.data.repository;

import com.app.java.grabfoodappproject.data.model.AdList;
import com.app.java.grabfoodappproject.data.model.FoodList;

public interface Repository {
    void makeGetFoodRequest(final RepositoryCallBack<FoodList> callBack);

    void makeGetAdRequest(final RepositoryCallBack<AdList> callBack);
}
