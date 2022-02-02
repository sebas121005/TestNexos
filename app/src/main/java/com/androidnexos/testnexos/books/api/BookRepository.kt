package com.androidnexos.testnexos.books.api

import com.androidnexos.testnexos.BuildConfig


class BookRepository {
    private var webService: WebService? = null

    init {
        webService = RetrofitManager().createWebService(BuildConfig.URL_SERVER)
    }
}