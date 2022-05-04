package com.willparken.control;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.willparken.R;
import com.willparken.model.User;

public class DashboardActivity extends AppCompatActivity {

    public static User currentUser;
    private Button dashboard_btn_viewprofile;
    private ImageButton dashboard_btn_logout;
    private CardView dashboard_cardview_editprofile, dashboard_cardview_checkreservations, dashboard_cardview_searchforparkingspot, dashboard_cardview_learn, dashboard_cardview_interests, dashboard_cardview_settings;
    private TextView dashboard_textview3;

    Intent intentViewProfile, intentEditProfile, intentLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        currentUser = (User) getIntent().getExtras().getSerializable("iUser");

        dashboard_btn_logout = findViewById(R.id.dashboard_btn_logout);
        dashboard_textview3 = findViewById(R.id.dashboard_textview3);
        dashboard_btn_viewprofile = findViewById(R.id.dashboard_btn_viewprofile);
        dashboard_cardview_editprofile = findViewById(R.id.dashboard_cardview_editprofile);
        dashboard_cardview_checkreservations = findViewById(R.id.dashboard_cardview_checkreservations);
        dashboard_cardview_searchforparkingspot = findViewById(R.id.dashboard_cardview_searchforparkingspot);
        dashboard_cardview_learn = findViewById(R.id.dashboard_cardview_learn);
        dashboard_cardview_interests = findViewById(R.id.dashboard_cardview_interests);
        dashboard_cardview_settings = findViewById(R.id.dashboard_cardview_settings);


        dashboard_btn_viewprofile.setOnClickListener(e -> openNewWindow(intentViewProfile));
        dashboard_btn_logout.setOnClickListener(e -> openNewWindow(intentLogin));
        dashboard_cardview_editprofile.setOnClickListener(e -> openNewWindow(intentEditProfile));
        dashboard_cardview_checkreservations.setOnClickListener(e -> showComingSoon());
        dashboard_cardview_searchforparkingspot.setOnClickListener(e -> showComingSoon());
        dashboard_cardview_learn.setOnClickListener(e -> showComingSoon());
        dashboard_cardview_interests.setOnClickListener(e -> showComingSoon());
        dashboard_cardview_settings.setOnClickListener(e -> showComingSoon());

        intentViewProfile = new Intent(this, ViewProfileActivity.class);
        intentEditProfile = new Intent(this, EditProfileActivity.class);
        intentLogin = new Intent(this, LoginActivity.class);

        fillFields();
    }

    public void openNewWindow(Intent i) {
        startActivity(i);
    }

    public void showComingSoon(){
        Toast.makeText(getApplicationContext(),"Coming Soon!",Toast.LENGTH_LONG).show();
    }

    @SuppressLint("SetTextI18n")
    private void fillFields() {
        dashboard_textview3.setText(DashboardActivity.currentUser.getFirstname() + " " + DashboardActivity.currentUser.getLastname());
    }
}

