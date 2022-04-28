package com.willparken.control;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.willparken.R;

public class EditProfileActivity extends AppCompatActivity {

    private Button cancelButton;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        cancelButton = (Button) findViewById(R.id.editprofile_cancel);
        saveButton = (Button) findViewById(R.id.editprofile_save);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openView();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openView();
            }
        });
    }

    public void openView(){

        Intent intent = new Intent(this, ViewProfileActivity.class);
        startActivity(intent);
    }
}

