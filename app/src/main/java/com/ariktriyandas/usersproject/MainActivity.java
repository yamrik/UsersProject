package com.ariktriyandas.usersproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView data;
    RecyclerView recyclerView;
    Adapter adapter;
    LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_data);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/users/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<GetData>> call = api.GetUserList();

        call.enqueue(new Callback<List<GetData>>() {
            @Override
            public void onResponse(Call<List<GetData>> call, Response<List<GetData>> response) {
                if(response.isSuccessful()){
                    List<GetData> users = response.body();
                    adapter = new Adapter(MainActivity.this,users);
                    recyclerView.setAdapter(adapter);
                    return;
                }
            }

            @Override
            public void onFailure(Call<List<GetData>> call, Throwable t) {

            }
        });

    }
}