package com.example.r3l0ad3d.tourmate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


public class SignUpActivity extends AppCompatActivity {

    private EditText fullNameET;
    private EditText userNameET;
    private EditText passWordET;
    private EditText confirmPasswordET;
    private EditText eMailET;
    private Button signUpBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fullNameET = (EditText) findViewById(R.id.etFullNameSignUp);
        userNameET = (EditText) findViewById(R.id.etUserNameSignUp);
        passWordET = (EditText) findViewById(R.id.etPasswordSignUp);
        confirmPasswordET = (EditText) findViewById(R.id.etConfirmPasswordSignUp);
        eMailET = (EditText) findViewById(R.id.etEmailSignUp);
        signUpBTN = (Button) findViewById(R.id.btnSignUp);
    }
}
