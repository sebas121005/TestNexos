package com.androidnexos.testnexos.books.detailbooks.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.androidnexos.testnexos.R
import com.androidnexos.testnexos.books.detailbooks.viewmodel.DetailBookViewModel
import com.androidnexos.testnexos.databinding.ActivityDetailBookBinding
import com.squareup.picasso.Picasso

class DetailBookActivity : AppCompatActivity() {
    private var mDetailBookBinding: ActivityDetailBookBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDetailBookBinding = ActivityDetailBookBinding.inflate(layoutInflater)
        val view = mDetailBookBinding?.root
        setContentView(view)
        initializeWidget()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }


    private fun initializeWidget() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.detalle_libro)

        showDetailBook()
    }

    private fun showDetailBook() {
        mDetailBookBinding?.bookNameDetail?.text = intent.extras?.getString(DetailBookViewModel.TITTLE_BOOK)
        mDetailBookBinding?.subtitleBookDetail?.text = intent.extras?.getString(DetailBookViewModel.SUBTITLE_BOOK)
        mDetailBookBinding?.priceBookDetail?.text = intent.extras?.getString(DetailBookViewModel.PRICE_BOOK)
        Picasso.get().load(intent.extras?.getString(DetailBookViewModel.IMAGE_BOOK)).into(mDetailBookBinding?.imageBook)


    }
}