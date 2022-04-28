package com.willparken.control;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.willparken.R;
import com.willparken.model.User;

public class DashboardActivity extends AppCompatActivity {

    public static User currentUser;
    private Button dashboard_btn_viewprofile;

    Intent intentViewProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        currentUser = (User) getIntent().getExtras().getSerializable("iUser");

        dashboard_btn_viewprofile = (Button) findViewById(R.id.dashboard_btn_viewprofile);
        dashboard_btn_viewprofile.setOnClickListener(e ->
                        openView()
                );


        intentViewProfile = new Intent(this, ViewProfileActivity.class);
    }

    public void openView(){
        startActivity(intentViewProfile);
    }
}

