package com.androidnexos.testnexos.books.api

import com.androidnexos.testnexos.BuildConfig
import com.androidnexos.testnexos.books.mainbooks.model.Book
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BookRepository {
    private var webService: WebService? = null

    init {
        webService = RetrofitManager().createWebService(BuildConfig.URL_SERVER)
    }

    fun getBooks(tittle: String, callbackHelper: ApiCallbackHelper.GeneralCallback<Book>) {
        webService?.getBooks(tittle)?.enqueue(object: Callback<Book> {
            override fun onResponse(call: Call<Book>, response: Response<Book>) {
                if (response.isSuccessful) {
                    response.body()?.let { callbackHelper.onSuccess(it) }
                }
            }

            override fun onFailure(call: Call<Book>, t: Throwable) {
                callbackHelper.onFailure()
            }

        })
    }
}