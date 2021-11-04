package com.willparken.control;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.willparken.R;
import com.willparken.model.SerializationFactory;
import com.willparken.model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    EditText txt_email,txt_password;
    Button btn_login,btn_register;

    Intent intentRegister;
    Intent intentHome;

    User iUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SerializationFactory.getInstance().restore(getApplicationContext());

        txt_email = (EditText) findViewById(R.id.txt_email);
        txt_password = (EditText) findViewById(R.id.txt_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_register);

        intentRegister = new Intent(this, RegisterActivity.class);
        intentHome = new Intent(this, OutputActivity.class);

        btn_login.setOnClickListener(v -> {
            clickOnLogin();
        });
        btn_register.setOnClickListener(v -> {
            finish();
            startActivity(intentRegister);
        });


        getSupportActionBar().hide();
    }


    void clickOnLogin(){
        Pattern emailPattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher emailMatcher = emailPattern.matcher(txt_email.getText().toString());
        if (!txt_email.getText().toString().equals("") && !txt_password.getText().toString().equals("")) {
            if (emailMatcher.matches()) {
                iUser = User.selectByEmailPassword(
                        txt_email.getText().toString(), txt_password.getText().toString());
            }else{
                Toast.makeText(getApplicationContext(),"This ain't no Email!",Toast.LENGTH_LONG).show();
            }
        }
        if (iUser != null)
        {
            intentHome.putExtra("iUser",iUser);
            finish();
            startActivity(intentHome);
        }
        else{
            Toast.makeText(getApplicationContext(),"Please check your input!",Toast.LENGTH_LONG).show();
        }
    }
}
