package com.androidnexos.testnexos.books.api;

import com.androidnexos.testnexos.books.mainbooks.model.Book;
import com.androidnexos.testnexos.books.mainbooks.model.ListBooks;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebService {
    @GET("search/{tittle}")
    Call<ListBooks> getBooks(
      @Path("tittle") String filterTittle
    );
}
