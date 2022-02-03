package com.androidnexos.testnexos.books.mainbooks.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidnexos.testnexos.R
import com.androidnexos.testnexos.books.detailbooks.view.DetailBookActivity
import com.androidnexos.testnexos.books.detailbooks.viewmodel.DetailBookViewModel
import com.androidnexos.testnexos.books.mainbooks.model.Book
import com.androidnexos.testnexos.books.mainbooks.model.ListBooks
import com.androidnexos.testnexos.books.mainbooks.view.adapter.BookAdapter
import com.androidnexos.testnexos.books.mainbooks.viewmodel.BookViewModel
import com.androidnexos.testnexos.databinding.ActivityMainBinding

class BookActivity : AppCompatActivity() {
    private var mBookBinding: ActivityMainBinding? = null
    private var mBookAdapter: BookAdapter? = null
    private var mViewModel: BookViewModel? = null

    private var dataBookList = ArrayList<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBookBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mBookBinding?.root
        setContentView(view)
        initializeWidgets()

        observables()
    }

    private fun initializeWidgets() {
        mViewModel = ViewModelProvider(this)[BookViewModel::class.java]
        mBookAdapter = BookAdapter(this, dataBookList, mViewModel)
        with(mBookBinding?.listBooks) {
            this?.layoutManager = LinearLayoutManager(this@BookActivity)
            this?.adapter = mBookAdapter
        }

        mViewModel?.getBooks("mongodb")

        mBookBinding?.searchBooks?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if (p0!!.isNotEmpty()) {
                    mViewModel?.getBooks(p0.toString())
                } else {
                    mViewModel?.getBooks("mongodb")
                }
            }

        })
    }

    private fun observables() {
        mViewModel?.showListBooksLiveDate?.observe(this, {
            it.listBooks.let { books ->
                dataBookList.clear()
                dataBookList.addAll(books)
                mBookAdapter?.notifyDataSetChanged()
            }
        })

        mViewModel?.showDetailBookLiveData?.observe(this, {
            val intentDetail = Intent(this, DetailBookActivity::class.java)
            intentDetail.putExtra(DetailBookViewModel.TITTLE_BOOK, it.tittleBook)
            intentDetail.putExtra(DetailBookViewModel.SUBTITLE_BOOK, it.subtitleBook)
            intentDetail.putExtra(DetailBookViewModel.PRICE_BOOK, it.priceBook)
            intentDetail.putExtra(DetailBookViewModel.IMAGE_BOOK, it.imageBook)
            startActivity(intentDetail)
        })
    }
}