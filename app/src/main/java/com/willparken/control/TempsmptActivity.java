package com.willparken.control;


import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;

import com.willparken.R;
import com.willparken.model.EmailUtility;

public class TempsmptActivity extends AppCompatActivity {
    /**
     * TempsmtpActivity.java und activity_tempsmtp.xml und implementierung im AndroidManifest.xml
     * bitte erst löschen, wenn EmailUtility.java korrekt implementiert wurde.
     * Vielen Dank für eure Aufmerksamkeit.
     */

    EditText txt_mailcontent;
    Button btn_send;
    EmailUtility emailUtility = new EmailUtility();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempsmtp);
        getSupportActionBar().hide();

        txt_mailcontent = (EditText) findViewById(R.id.txt_mailcontent);
        btn_send = (Button) findViewById(R.id.btn_send);

        btn_send.setOnClickListener(e -> clickOnSend());
    }

    private void clickOnSend(){
        emailUtility.sendMail( "arbi.saidov@gmx.at", "Hello Member", "Thanks for joining us." );
    }
}
