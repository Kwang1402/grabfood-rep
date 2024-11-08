package com.app.java.grabfoodappproject.data.repository;

import com.app.java.grabfoodappproject.data.remote_datasource.Result;

public interface RepositoryCallBack<T> {
    void onCompleted(Result<T> result);
}
