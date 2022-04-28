package com.willparken.control;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.willparken.R;

public class EditProfileActivity extends AppCompatActivity {

    private Button editprofile_btn_cancel;
    private Button editprofile_btn_save;
    private TextView editprofile_txt_firstname, editprofile_txt_lastname, editprofile_txt_tel, editprofile_txt_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        editprofile_btn_cancel = (Button) findViewById(R.id.editprofile_btn_cancel);
        editprofile_btn_save = (Button) findViewById(R.id.editprofile_btn_save);

        editprofile_txt_firstname = (TextView) findViewById(R.id.editprofile_txt_firstname);
        editprofile_txt_lastname = (TextView) findViewById(R.id.editprofile_txt_lastname);
        editprofile_txt_tel = (TextView) findViewById(R.id.editprofile_txt_tel);
        editprofile_txt_password = (TextView) findViewById(R.id.editprofile_txt_password);

        editprofile_btn_cancel.setOnClickListener(e -> clickOnCancel());
        editprofile_btn_save.setOnClickListener(e -> clickOnCancel());

        fillFields();
    }

    public void clickOnCancel(){

        Intent intent = new Intent(this, ViewProfileActivity.class);
        startActivity(intent);
        finish();
    }

    @SuppressLint("SetTextI18n")
    private void fillFields(){
        editprofile_txt_firstname.setText(DashboardActivity.currentUser.getFirstname());
        editprofile_txt_lastname.setText(DashboardActivity.currentUser.getLastname());
        editprofile_txt_tel.setText(DashboardActivity.currentUser.getTelephoneNumber());
        editprofile_txt_password.setText("");
    }
}

