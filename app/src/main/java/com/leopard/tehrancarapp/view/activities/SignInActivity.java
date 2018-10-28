package com.leopard.tehrancarapp.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.leopard.tehrancarapp.R;
import com.leopard.tehrancarapp.controller.network.ApiService;
import com.leopard.tehrancarapp.controller.network.RetrofitClientInstance;
import com.leopard.tehrancarapp.model.LoginInfo;
import com.leopard.tehrancarapp.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {

    @BindView(R.id.edittext_signin_username)
    AppCompatEditText edittextsigninUsername;
    @BindView(R.id.edittext_signin_password)
    AppCompatEditText edittextsigninPassword;
    @BindView(R.id.button_signin)
    Button buttonsignin;
    @BindView(R.id.checkbox_signin_admin)
    AppCompatCheckBox checkboxSigninAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
        checkboxSigninAdmin.setTypeface(ResourcesCompat.getFont(SignInActivity.this, R.font.font_normal));
    }

    @OnClick(R.id.button_signin)
    public void onViewClicked() {
        if (validate()) {
            ApiService service = RetrofitClientInstance.getRetrofitInstance().create(ApiService.class);
            Call<User> call = service.loginUser(new LoginInfo(edittextsigninUsername.getText().toString(),
                    edittextsigninPassword.getText().toString()));
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if (response.isSuccessful()) {
                        if (checkboxSigninAdmin.isChecked()) {
                            startActivity(new Intent(SignInActivity.this, ListCarsAdminActivity.class));
                            finish();
                        } else {
                            Toast.makeText(SignInActivity.this, response.body().getUsername() + " Logged In", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignInActivity.this, ListCarActivity.class));
                            finish();
                        }
                    } else {
                        Toast.makeText(SignInActivity.this, "Logging Failed", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toast.makeText(SignInActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public boolean validate() {
        boolean valid = true;

        String email = edittextsigninUsername.getText().toString();
        String password = edittextsigninPassword.getText().toString();

        if (email.isEmpty()) {
            edittextsigninUsername.setError("enter a valid email address");
            requestFocus(edittextsigninUsername);
            valid = false;
        } else {
            edittextsigninUsername.setError(null);
        }

        if (password.isEmpty()) {
            edittextsigninPassword.setError("Password is empty");
            requestFocus(edittextsigninPassword);
            valid = false;
        } else {
            edittextsigninPassword.setError(null);
        }

        return valid;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
    @OnClick(R.id.button_signup)
    public void onClick(){
        startActivity(new Intent(SignInActivity.this,WebViewActivity.class));

    }
}
