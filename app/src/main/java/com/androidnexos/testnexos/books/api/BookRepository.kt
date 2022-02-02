package com.androidnexos.testnexos.books.api

import com.androidnexos.testnexos.BuildConfig
import com.androidnexos.testnexos.books.mainbooks.model.Book


class BookRepository {
    private var webService: WebService? = null

    init {
        webService = RetrofitManager().createWebService(BuildConfig.URL_SERVER)
    }

    fun getBooks(callbackHelper: ApiCallbackHelper.GeneralCallback<Book>) {

    }
}