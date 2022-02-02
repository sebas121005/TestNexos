package com.androidnexos.testnexos.books.api;

import com.androidnexos.testnexos.books.mainbooks.model.Book;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebService {
    @GET("search/{tittle}")
    Call<Book> getBooks(
      @Path("tittle") String filterTittle
    );
}
