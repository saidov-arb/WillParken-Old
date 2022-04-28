package com.willparken.control;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.willparken.R;


public class ViewProfileActivity extends AppCompatActivity {

    private Button editButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewprofile);

        editButton = (Button) findViewById(R.id.viewprofile_edit);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openEdit();
            }
        });
    }

    public void openEdit(){

        Intent intent = new Intent(this, EditProfileActivity.class);
        startActivity(intent);
    }
}