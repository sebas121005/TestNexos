package com.androidnexos.testnexos.books.api;

public class ApiCallbackHelper {
    public interface GeneralCallback <T> {
        void onSuccess(T response);
        void onFailure();
    }
}
