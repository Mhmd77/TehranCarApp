package com.leopard.tehrancarapp.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.leopard.tehrancarapp.R;
import com.leopard.tehrancarapp.controller.network.ApiService;
import com.leopard.tehrancarapp.controller.CarBuilder;
import com.leopard.tehrancarapp.controller.network.RetrofitClientInstance;
import com.leopard.tehrancarapp.model.Car;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddCarAdminActivity extends AppCompatActivity implements Callback<Car> {

    @BindView(R.id.editText_addCar_name)
    EditText editTextAddCarName;
    @BindView(R.id.editText_addCar_factory)
    EditText editTextAddCarFactory;
    @BindView(R.id.editText_addCar_year)
    EditText editTextAddCarYear;
    @BindView(R.id.editText_addCar_kilometer)
    EditText editTextAddCarKilometer;
    @BindView(R.id.editText_addCar_color)
    EditText editTextAddCarColor;
    @BindView(R.id.checkbox_addCar_automate)
    CheckBox editTextAddCarAutomate;
    @BindView(R.id.editText_addCar_price)
    EditText editTextAddCarPrice;
    @BindView(R.id.button_addCar)
    Button buttonAddCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car_admin);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_addCar)
    public void onViewClicked() {
        CarBuilder builder = new CarBuilder()
                .setName(editTextAddCarName.getText().toString())
                .setColor(editTextAddCarColor.getText().toString())
                .setFactory(editTextAddCarFactory.getText().toString())
                .setKilometer(Integer.parseInt(editTextAddCarKilometer.getText().toString()))
                .setPrice(Integer.parseInt(editTextAddCarPrice.getText().toString()))
                .setYear(Integer.parseInt(editTextAddCarYear.getText().toString()))
                .setAutomate(editTextAddCarAutomate.isChecked());
        addCar(builder.createCar());
    }

    private void addCar(Car car) {
        ApiService service = RetrofitClientInstance.getRetrofitInstance().create(ApiService.class);
        Call<Car> call = service.addCar(car);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Car> call, Response<Car> response) {
        if (response.isSuccessful()) {
            Log.i("Connection", "Car Added Successfully with id " + response.body().getId());
            finish();
        } else {
            Log.e("Connection", "Failed To Add Car : " + response.message());
        }
    }

    @Override
    public void onFailure(Call<Car> call, Throwable t) {
        Log.e("Connection", "Failed To Connect : " + t.getMessage());

    }
}
