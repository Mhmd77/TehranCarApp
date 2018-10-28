package com.leopard.tehrancarapp.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.leopard.tehrancarapp.R;
import com.leopard.tehrancarapp.controller.network.ApiService;
import com.leopard.tehrancarapp.controller.adapter.CarsRecyclerView;
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

public class ListCarsAdminActivity extends AppCompatActivity implements Callback<List<Car>> {

    @BindView(R.id.recyclerView_main_cars)
    RecyclerView recyclerViewMainCars;
    @BindView(R.id.actionButton_main_add_car)
    FloatingActionButton actionButtonMainAddCar;
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
        adapter = new CarsRecyclerView(this, cars, new CarsRecyclerView.OnItemClickListener() {
            @Override
            public void onItemClick(final int position) {
                Call<ResponseJson> call = service.deleteCar(cars.get(position).getId());
                call.enqueue(new Callback<ResponseJson>() {
                    @Override
                    public void onResponse(Call<ResponseJson> call, Response<ResponseJson> response) {
                        if (response.isSuccessful()) {
                            Log.i("Conncection", "Car " + cars.get(position).getId() + " deleted");
                            updateList();
                        } else {
                            Log.e("Conncection", "Deleting Car Failed : " + response.message());
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseJson> call, Throwable t) {
                        Log.e("Conncection", "Deleting Car Failed : " + t.getMessage());
                    }
                });
            }
        });
        recyclerViewMainCars.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMainCars.setAdapter(adapter);
    }

    @OnClick(R.id.actionButton_main_add_car)
    public void onViewClicked() {
        Intent intent = new Intent(ListCarsAdminActivity.this, AddCarAdminActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
        generateDataList(response.body());
    }

    @Override
    public void onFailure(Call<List<Car>> call, Throwable t) {
        Toast.makeText(ListCarsAdminActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateList();
    }
}
