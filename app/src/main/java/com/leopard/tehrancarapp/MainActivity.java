package com.leopard.tehrancarapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.leopard.tehrancarapp.adapter.CarsRecyclerView;
import com.leopard.tehrancarapp.model.Car;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView_main_cars)
    RecyclerView recyclerViewMainCars;
    @BindView(R.id.actionButton_main_add_car)
    FloatingActionButton actionButtonMainAddCar;
    List<Car> cars = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        CarsRecyclerView adapter = new CarsRecyclerView(this, cars, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        recyclerViewMainCars.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMainCars.setAdapter(adapter);
    }

    @OnClick(R.id.actionButton_main_add_car)
    public void onViewClicked() {
    }
}
