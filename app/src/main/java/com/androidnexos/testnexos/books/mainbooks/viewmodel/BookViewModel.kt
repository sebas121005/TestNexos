package com.androidnexos.testnexos.books.mainbooks.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidnexos.testnexos.books.api.ApiCallbackHelper
import com.androidnexos.testnexos.books.api.BookRepository
import com.androidnexos.testnexos.books.mainbooks.model.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BookViewModel: ViewModel() {
    private val mBookRepository = BookRepository()

    val showListBooksLiveDate = MutableLiveData<Book>()

    fun getBooks(tittle: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                mBookRepository.getBooks(tittle, object : ApiCallbackHelper.GeneralCallback<Book> {
                    override fun onSuccess(response: Book?) {
                        showListBooksLiveDate.value = response
                    }

                    override fun onFailure() {
                    }

                })
            }
        }
    }
}