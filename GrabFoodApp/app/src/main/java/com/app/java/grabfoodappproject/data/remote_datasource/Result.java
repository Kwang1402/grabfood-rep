package com.app.java.grabfoodappproject.data.remote_datasource;

public abstract class Result<T> {
    public static final class Success<T> extends Result<T>{
        public T data;
        public Success(T data){
            this.data = data;
        }
    }

    public static final class Error<T> extends Result<T>{
        public Exception e;
        public Error(Exception exception){
            this.e = exception;
        }
    }
}
