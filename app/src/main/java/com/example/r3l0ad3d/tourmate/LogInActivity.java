package com.example.r3l0ad3d.tourmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogInActivity extends AppCompatActivity {

    private EditText userNameET;
    private EditText passWordET;
    private Button logInBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        userNameET = (EditText) findViewById(R.id.etUserNameSignIn);
        passWordET = (EditText) findViewById(R.id.etPasswordSignIn);
        logInBTN = (Button) findViewById(R.id.btnSignIn);
    }

    public void onClickSignUpActivity(View view) {
        Intent intent = new Intent(this,SignUpActivity.class);
        startActivity(intent);
    }
}
