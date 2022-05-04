package com.willparken.control;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.willparken.R;
import com.willparken.model.SerializationFactory;
import com.willparken.model.User;

public class EditProfileActivity extends AppCompatActivity {

    private Button editprofile_btn_cancel;
    private Button editprofile_btn_save;
    private TextView editprofile_txt_firstname, editprofile_txt_lastname, editprofile_txt_tel, editprofile_txt_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        editprofile_btn_cancel = (Button) findViewById(R.id.editprofile_btn_cancel);
        editprofile_btn_save = (Button) findViewById(R.id.editprofile_btn_save);

        editprofile_txt_firstname = (TextView) findViewById(R.id.editprofile_txt_firstname);
        editprofile_txt_lastname = (TextView) findViewById(R.id.editprofile_txt_lastname);
        editprofile_txt_tel = (TextView) findViewById(R.id.editprofile_txt_tel);
        editprofile_txt_address = (TextView) findViewById(R.id.editprofile_txt_address);

        editprofile_btn_cancel.setOnClickListener(e -> clickOnCancel());
        editprofile_btn_save.setOnClickListener(e -> clickOnSave());

        fillFields();
    }

    public void clickOnCancel() {
        Intent intent = new Intent(this, ViewProfileActivity.class);
        startActivity(intent);
        finish();
    }

    @SuppressLint("SetTextI18n")
    public void clickOnSave() {
        if (!editprofile_txt_firstname.getText().toString().equals("") || !editprofile_txt_lastname.getText().toString().equals("") || !editprofile_txt_tel.getText().toString().equals("") || !editprofile_txt_address.getText().toString().equals("")) {
            DashboardActivity.currentUser.setFirstname(editprofile_txt_firstname.getText().toString());
            DashboardActivity.currentUser.setLastname(editprofile_txt_lastname.getText().toString());
            DashboardActivity.currentUser.setAddress(editprofile_txt_address.getText().toString());
            DashboardActivity.currentUser.setTelephoneNumber(editprofile_txt_tel.getText().toString());
            DashboardActivity.currentUser.save();
            SerializationFactory.getInstance().persist(getApplicationContext());
            Toast.makeText(getApplicationContext(), "Profile updated!", Toast.LENGTH_LONG).show();
            clickOnCancel();
        } else {
            Toast.makeText(getApplicationContext(), "Fill out all fields!", Toast.LENGTH_LONG).show();
        }
    }

    @SuppressLint("SetTextI18n")
    private void fillFields() {
        editprofile_txt_firstname.setText(DashboardActivity.currentUser.getFirstname());
        editprofile_txt_lastname.setText(DashboardActivity.currentUser.getLastname());
        editprofile_txt_tel.setText(DashboardActivity.currentUser.getTelephoneNumber());
        editprofile_txt_address.setText(DashboardActivity.currentUser.getAddress());
    }
}

