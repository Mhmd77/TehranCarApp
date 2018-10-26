package com.leopard.tehrancarapp.controller;

import com.leopard.tehrancarapp.model.Car;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCarService {
    @GET("/listCar")
    Call<List<Car>> getAllCars();
}
