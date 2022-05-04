package com.willparken.control;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.willparken.R;
import com.willparken.model.Parkingblock;
import com.willparken.model.Parkingspot;
import com.willparken.model.ParkingspotReservation;
import com.willparken.model.User;

import java.time.LocalDateTime;

public class DashboardActivity extends AppCompatActivity {

    public static User currentUser;
    private Button dashboard_btn_viewprofile;
    private ImageButton dashboard_btn_logout;
    private CardView dashboard_cardview_editprofile, dashboard_cardview_checkreservations, dashboard_cardview_searchforparkingspot, dashboard_cardview_learn, dashboard_cardview_interests, dashboard_cardview_settings;
    private TextView dashboard_textview3;

    Intent intentViewProfile, intentEditProfile, intentLogin, intentViewParkingblock;

    @RequiresApi(api = Build.VERSION_CODES.O)
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

        intentViewProfile = new Intent(this, ViewProfileActivity.class);
        intentEditProfile = new Intent(this, EditProfileActivity.class);
        intentLogin = new Intent(this, LoginActivity.class);
        intentViewParkingblock = new Intent(this, ViewParkingblockActivity.class);

        dashboard_btn_viewprofile.setOnClickListener(e -> openNewWindow(intentViewProfile));
        dashboard_btn_logout.setOnClickListener(e -> openNewWindow(intentLogin));
        dashboard_cardview_editprofile.setOnClickListener(e -> openNewWindow(intentEditProfile));
        dashboard_cardview_checkreservations.setOnClickListener(e -> showComingSoon());
        dashboard_cardview_searchforparkingspot.setOnClickListener(e -> openNewWindow(intentViewParkingblock));
        dashboard_cardview_learn.setOnClickListener(e -> showComingSoon());
        dashboard_cardview_interests.setOnClickListener(e -> showComingSoon());
        dashboard_cardview_settings.setOnClickListener(e -> showComingSoon());


        fillFields();

//        Parkingspot ps1 = new Parkingspot(1);
//        ParkingspotReservation res1 = new ParkingspotReservation(
//                LocalDateTime.of(2022,1,1,0,0,0),
//                LocalDateTime.of(2022,1,1,0,30,0),
//                currentUser
//        );
//        ParkingspotReservation res2 = new ParkingspotReservation(
//                LocalDateTime.of(2022,1,1,0,30,1),
//                LocalDateTime.of(2022,1,1,1,0,0),
//                currentUser
//        );
//        ParkingspotReservation res3 = new ParkingspotReservation(
//                LocalDateTime.of(2022,1,1,0,15,1),
//                LocalDateTime.of(2022,1,1,1,15,0),
//                currentUser
//        );
//        System.out.println("res1: "+ps1.reserveSpot(res1));
//        System.out.println("res2: "+ps1.reserveSpot(res2));
//        System.out.println("res3: "+ps1.reserveSpot(res3));
//
//        System.out.println(ps1.toString());
//
//        System.out.println(
//                ps1.getReservationsInTimeRange(
//                    LocalDateTime.of(2022,1,1,0,31,0),
//                    LocalDateTime.of(2022,1,1,0,45,0)
//                )
//        );





//        Parkingblock block = new Parkingblock();
//        block.setBlockname("HTL-Wels");
//        block.fillWithRandomSpots();
//
//        block.reserveParkingspot(
//                1,
//                LocalDateTime.of(2022,1,1,0,30,1),
//                LocalDateTime.of(2022,1,1,1,0,0),
//                currentUser
//        );
//        block.reserveParkingspot(
//                2,
//                LocalDateTime.of(2022,1,1,2,30,1),
//                LocalDateTime.of(2022,1,1,3,0,0),
//                currentUser
//        );
//
//        System.out.println(block);
//
//        System.out.println(
//                block.getReservationsForSpotInTimeRange(
//                        2,
//                        LocalDateTime.of(2022,1,1,2,50,1),
//                        LocalDateTime.of(2022,1,1,3,0,0)
//                )
//        );
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

