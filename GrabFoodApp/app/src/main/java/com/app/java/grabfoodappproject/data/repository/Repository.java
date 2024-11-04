package com.app.java.grabfoodappproject.data.repository;

import com.app.java.grabfoodappproject.data.model.FoodList;

public interface Repository {
    // TODO: request api
    void makeGetFoodRequest(final RepositoryCallBack<FoodList> callBack);
}
