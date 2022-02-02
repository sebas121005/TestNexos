package com.androidnexos.testnexos.books.mainbooks.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidnexos.testnexos.R
import com.androidnexos.testnexos.books.mainbooks.model.Book
import com.androidnexos.testnexos.books.mainbooks.view.adapter.BookAdapter
import com.androidnexos.testnexos.databinding.ActivityMainBinding

class BookActivity : AppCompatActivity() {
    private var mBookBinding: ActivityMainBinding? = null
    private var mBookAdapter: BookAdapter? = null

    private var dataBookList = ArrayList<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBookBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mBookBinding?.root
        setContentView(view)
    }

    private fun initializeWidgets() {
        mBookAdapter = BookAdapter(this, dataBookList)
        with(mBookBinding?.listBooks) {
            this?.layoutManager = LinearLayoutManager(this@BookActivity)
            this?.adapter = mBookAdapter
        }
    }
}