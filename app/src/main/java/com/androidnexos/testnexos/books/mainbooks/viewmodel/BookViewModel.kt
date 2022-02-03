package com.androidnexos.testnexos.books.mainbooks.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidnexos.testnexos.books.api.ApiCallbackHelper
import com.androidnexos.testnexos.books.api.BookRepository
import com.androidnexos.testnexos.books.mainbooks.model.Book
import com.androidnexos.testnexos.books.mainbooks.model.ListBooks
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BookViewModel: ViewModel() {
    private val mBookRepository = BookRepository()

    val showListBooksLiveDate = MutableLiveData<ListBooks>()
    val showDetailBookLiveData = MutableLiveData<Book>()

    fun getBooks(tittle: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                mBookRepository.getBooks(tittle, object : ApiCallbackHelper.GeneralCallback<ListBooks> {
                    override fun onSuccess(response: ListBooks?) {
                        showListBooksLiveDate.value = response
                    }

                    override fun onFailure() {
                    }

                })
            }
        }
    }
}