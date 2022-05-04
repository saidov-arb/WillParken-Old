package com.willparken.control;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.willparken.R;


public class ViewProfileActivity extends AppCompatActivity {

    private Button viewprofile_btn_edit;
    private TextView viewprofile_txt_firstname, viewprofile_txt_lastname, viewprofile_txt_tel, viewprofile_txt_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewprofile);

        viewprofile_btn_edit = (Button) findViewById(R.id.viewprofile_btn_edit);
        viewprofile_txt_firstname = (TextView) findViewById(R.id.viewprofile_txt_firstname);
        viewprofile_txt_lastname = (TextView) findViewById(R.id.viewprofile_txt_lastname);
        viewprofile_txt_tel = (TextView) findViewById(R.id.viewprofile_txt_tel);
        viewprofile_txt_address = (TextView) findViewById(R.id.viewprofile_txt_address);

        viewprofile_btn_edit.setOnClickListener(e -> clickOnEdit());

        fillFields();
    }

    private void clickOnEdit(){

        Intent intent = new Intent(this, EditProfileActivity.class);
        startActivity(intent);
        finish();
    }

    @SuppressLint("SetTextI18n")
    private void fillFields(){
        viewprofile_txt_firstname.setText(viewprofile_txt_firstname.getText()+" "+DashboardActivity.currentUser.getFirstname());
        viewprofile_txt_lastname.setText(viewprofile_txt_lastname.getText()+" "+DashboardActivity.currentUser.getLastname());
        viewprofile_txt_tel.setText(viewprofile_txt_tel.getText()+" "+DashboardActivity.currentUser.getTelephoneNumber());
        viewprofile_txt_address.setText(viewprofile_txt_address.getText()+" "+DashboardActivity.currentUser.getAddress());
    }
}