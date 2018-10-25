package com.leopard.tehrancarapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.leopard.tehrancarapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity {

    @BindView(R.id.signup_username)
    TextView signupUsername;
    @BindView(R.id.siginup_password)
    TextView siginupPassword;
    @BindView(R.id.signup_email)
    TextView signupEmail;
    @BindView(R.id.siginup_btn)
    Button siginupBtn;
    @BindView(R.id.siginup_logpage_btn)
    Button siginupLogpageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.siginup_btn, R.id.siginup_logpage_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.siginup_btn:
                SignUp();
            case R.id.siginup_logpage_btn:
                startActivity(new Intent(SignUpActivity.this,SignInActivity.class));
        }
    }

    private void SignUp() {
        String userName;
        String passWord;
        String email;
        userName = signupUsername.getText().toString();
        passWord = siginupPassword.getText().toString();
        email = signupEmail.getText().toString();
        checkSignUp(userName,passWord,email);
    }

    private void checkSignUp(String userName, String passWord, String email) {
        //TODo
    }
}
