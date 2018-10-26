package com.leopard.tehrancarapp.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.leopard.tehrancarapp.R;
import com.leopard.tehrancarapp.controller.GetCarService;
import com.leopard.tehrancarapp.controller.adapter.CarsRecyclerView;
import com.leopard.tehrancarapp.controller.network.RetrofitClientInstance;
import com.leopard.tehrancarapp.model.Car;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView_main_cars)
    RecyclerView recyclerViewMainCars;
    @BindView(R.id.actionButton_main_add_car)
    FloatingActionButton actionButtonMainAddCar;
    private List<Car> cars = new ArrayList<>();
    private static final int GET_CAR_CODE = 1;
    private CarsRecyclerView adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        GetCarService service = RetrofitClientInstance.getRetrofitInstance().create(GetCarService.class);
        Call<List<Car>> call = service.getAllCars();
        call.enqueue(new Callback<List<Car>>() {
            @Override
            public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Car>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(List<Car> body) {
        adapter = new CarsRecyclerView(this, body, new CarsRecyclerView.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                cars.remove(position);
            }
        });
        recyclerViewMainCars.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMainCars.setAdapter(adapter);
    }

    @OnClick(R.id.actionButton_main_add_car)
    public void onViewClicked() {
        Intent intent = new Intent(MainActivity.this, AddCarAdminActivity.class);
        startActivityForResult(intent, GET_CAR_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case GET_CAR_CODE:
                if (resultCode == RESULT_OK) {
                    Car car = (Car) data.getSerializableExtra(Car.class.getSimpleName());
                    cars.add(car);
                    adapter.notifyDataSetChanged();
                }
                break;
        }
    }
}
