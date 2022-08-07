package com.thecodecity.teenyexamples.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.thecodecity.teenyexamples.R;
import com.thecodecity.teenyexamples.networking.ProductResult;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class RVRetrofitAdapter extends RecyclerView.Adapter<RVRetrofitAdapter.RVHolderRetrofit> {
    Context mContext;
    List<ProductResult> productResults;

    public RVRetrofitAdapter(Context mContext, List<ProductResult> productResults) {
        this.productResults = productResults;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RVHolderRetrofit onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rv_product_item, parent, false);
        return new RVHolderRetrofit(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVHolderRetrofit holder, int position) {
        holder.tvTitle.setText(productResults.get(position).getTitle());
        Glide.with(mContext).
                load(productResults.get(position).getProductImage()).placeholder(R.drawable.camino).
                error(R.drawable.ic_launcher_background).into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return productResults.size();
    }

    public class RVHolderRetrofit extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView ivImage;

        public RVHolderRetrofit(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }
}
