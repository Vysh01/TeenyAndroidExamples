package com.thecodecity.teenyexamples;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thecodecity.teenyexamples.adapters.RVRetrofitAdapter;
import com.thecodecity.teenyexamples.networking.ProductResult;
import com.thecodecity.teenyexamples.networking.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityRvProducts extends AppCompatActivity {
    RecyclerView rvProducts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_products);
        rvProducts = findViewById(R.id.rvProducts);

        getProducts();
    }

    private void getProducts() {
        Call<List<ProductResult>> apiCall = RetrofitClient.getInstance().getApis().getProducts();
        apiCall.enqueue(new Callback<List<ProductResult>>() {
            @Override
            public void onResponse(Call<List<ProductResult>> call, Response<List<ProductResult>> response) {
                List<ProductResult> productResults = response.body();
                Toast.makeText(ActivityRvProducts.this, "Got Products", Toast.LENGTH_SHORT).show();
                setAdapter(productResults);
            }

            @Override
            public void onFailure(Call<List<ProductResult>> call, Throwable t) {
                Toast.makeText(ActivityRvProducts.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setAdapter(List<ProductResult> productResults) {
        rvProducts.setLayoutManager(new LinearLayoutManager(this));
        RVRetrofitAdapter rvRetrofitAdapter = new RVRetrofitAdapter(this, productResults);
        rvProducts.setAdapter(rvRetrofitAdapter);

    }
}
