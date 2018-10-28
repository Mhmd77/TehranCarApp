package com.leopard.tehrancarapp.view.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.leopard.tehrancarapp.R;
import com.leopard.tehrancarapp.controller.adapter.CarsRecyclerView;
import com.leopard.tehrancarapp.controller.network.ApiService;
import com.leopard.tehrancarapp.controller.network.RetrofitClientInstance;
import com.leopard.tehrancarapp.model.Car;
import com.leopard.tehrancarapp.model.ResponseJson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListCarActivity extends AppCompatActivity implements Callback<List<Car>> {

    @BindView(R.id.recyclerView_main_cars)
    RecyclerView recyclerViewMainCars;
    private CarsRecyclerView adapter;
    private ApiService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_list_car);
        ButterKnife.bind(this);

        service = RetrofitClientInstance.getRetrofitInstance().create(ApiService.class);
        updateList();
    }

    private void updateList() {
        Call<List<Car>> call = service.getAllCars();
        call.enqueue(this);
    }

    private void generateDataList(final List<Car> cars) {
        adapter = new CarsRecyclerView(this, cars);
        recyclerViewMainCars.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMainCars.setAdapter(adapter);
    }

    @Override
    public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
        generateDataList(response.body());
    }

    @Override
    public void onFailure(Call<List<Car>> call, Throwable t) {
        Toast.makeText(ListCarActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateList();
    }
}
