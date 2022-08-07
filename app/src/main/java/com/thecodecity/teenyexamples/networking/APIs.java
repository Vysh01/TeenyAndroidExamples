package com.thecodecity.teenyexamples.networking;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIs {
    String BASE_URL = "https://fakestoreapi.com/";

    @GET("products")
    Call<List<ProductResult>> getProducts();
}
