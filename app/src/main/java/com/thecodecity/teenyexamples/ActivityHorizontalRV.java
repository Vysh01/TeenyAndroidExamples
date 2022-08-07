package com.thecodecity.teenyexamples;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.TaskStackBuilder;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ActivityHorizontalRV extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<String> dataSource;
    LinearLayoutManager linearLayoutManager;
    MyRvAdapter myRvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_rv);
        rv = findViewById(R.id.horizontalRv);

        //Setting the data source
        dataSource = new ArrayList<>();
        dataSource.add("Hello");
        dataSource.add("World");
        dataSource.add("To");
        dataSource.add("The");
        dataSource.add("Code");
        dataSource.add("City");
        dataSource.add("******");

        linearLayoutManager = new LinearLayoutManager(ActivityHorizontalRV.this, LinearLayoutManager.HORIZONTAL, false);
        myRvAdapter = new MyRvAdapter(dataSource);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(myRvAdapter);
    }

    class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.MyHolder> {
        ArrayList<String> data;

        public MyRvAdapter(ArrayList<String> data) {
            this.data = data;
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(ActivityHorizontalRV.this).inflate(R.layout.rv_item, parent, false);
            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            holder.tvTitle.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class MyHolder extends RecyclerView.ViewHolder {
            TextView tvTitle;

            public MyHolder(@NonNull View itemView) {
                super(itemView);
                tvTitle = itemView.findViewById(R.id.tvTitle);
            }
        }

    }
}
