package com.willparken.control;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.willparken.R;
import com.willparken.model.User;

public class OutputActivity extends AppCompatActivity {

    TextView txt_output;
    User iUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        iUser = (User) getIntent().getExtras().getSerializable("iUser");
        txt_output = (TextView) findViewById(R.id.txt_output);

        txt_output.setText(iUser.toString());
    }
}