package com.willparken.control;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.willparken.R;

public class ParkingspotSearchMaskActivity extends AppCompatActivity {

    DatePicker dat_from,dat_until;
    TimePicker tim_from,tim_until;
    Button btn_search, btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parkingspotsearchmask);

        dat_from = (DatePicker) findViewById(R.id.pssm_dat_from);
        dat_until = (DatePicker) findViewById(R.id.pssm_dat_until);
        tim_from = (TimePicker) findViewById(R.id.pssm_tim_from);
        tim_until = (TimePicker) findViewById(R.id.pssm_tim_until);
        btn_search = (Button) findViewById(R.id.pssm_btn_search);
        btn_cancel = (Button) findViewById(R.id.pssm_btn_cancel);

        btn_cancel.setOnClickListener(e -> {
            finish();
        });

        btn_search.setOnClickListener(e -> clickOnBtnSearch());
    }

    private void clickOnBtnSearch(){

    }
}