package com.app.java.grabfoodappproject.data.repository;

import com.app.java.grabfoodappproject.data.remote.Result;

public interface RepositoryCallBack<T> {
    void onCompleted(Result<T> result);
}
