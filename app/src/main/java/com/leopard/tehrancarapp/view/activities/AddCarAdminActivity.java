package com.leopard.tehrancarapp.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.leopard.tehrancarapp.R;
import com.leopard.tehrancarapp.controller.CarBuilder;
import com.leopard.tehrancarapp.model.Car;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddCarAdminActivity extends AppCompatActivity {

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
        Intent intent = new Intent();
        intent.putExtra(Car.class.getSimpleName(), builder.createCar());
        setResult(RESULT_OK, intent);
        finish();
    }
}
