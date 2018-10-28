package com.leopard.tehrancarapp.controller.network;

import com.leopard.tehrancarapp.model.Car;
import com.leopard.tehrancarapp.model.LoginInfo;
import com.leopard.tehrancarapp.model.ResponseJson;
import com.leopard.tehrancarapp.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @GET("/app/listCar")
    Call<List<Car>> getAllCars();

    @POST("/app/login")
    Call<User> loginUser(@Body LoginInfo user);

    @POST("/app/addCar")
    Call<Car> addCar(@Body Car car);

    @DELETE("/app/deleteCar/{id}")
    Call<ResponseJson> deleteCar(@Path("id") int id);
}
