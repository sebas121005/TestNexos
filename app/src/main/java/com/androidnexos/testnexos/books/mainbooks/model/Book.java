package com.androidnexos.testnexos.books.mainbooks.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Book {
    @SerializedName("title")
    @Expose
    public String tittleBook;

    @SerializedName("subtitle")
    @Expose
    public String subtitleBook;

    @SerializedName("price")
    @Expose
    public String priceBook;
}
