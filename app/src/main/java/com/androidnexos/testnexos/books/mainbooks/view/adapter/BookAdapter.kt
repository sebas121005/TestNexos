package com.androidnexos.testnexos.books.mainbooks.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidnexos.testnexos.books.mainbooks.model.Book
import com.androidnexos.testnexos.databinding.ItemBookBinding

class BookAdapter(private val context: Context, private val dataBook: List<Book>):
    RecyclerView.Adapter<BookAdapter.ViewHolderBook>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderBook {
        val itemBookBinding = ItemBookBinding.inflate(LayoutInflater.from(context),
            parent, false)

        return ViewHolderBook(itemBookBinding)
    }

    override fun onBindViewHolder(holder: ViewHolderBook, position: Int) {
        holder.addItemMovie(dataBook[position])
    }

    override fun getItemCount(): Int {
        return dataBook.size
    }

    class ViewHolderBook(private val itemBookBinding: ItemBookBinding):
        RecyclerView.ViewHolder(itemBookBinding.root){
        fun addItemMovie(book: Book) {
            itemBookBinding.bookName.text = book.tittleBook
            itemBookBinding.subtitleBook.text = book.subtitleBook
            itemBookBinding.priceBook.text = book.priceBook
        }
    }
}