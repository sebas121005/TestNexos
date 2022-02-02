package com.androidnexos.testnexos.books.mainbooks.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListBooks {
    @SerializedName("books")
    @Expose
    public List<Book> listBooks;
}
