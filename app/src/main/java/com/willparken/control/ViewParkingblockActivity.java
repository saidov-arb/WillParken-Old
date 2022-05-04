package com.willparken.control;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.willparken.R;
import com.willparken.customcontrol.ParkingblockItem;
import com.willparken.model.Parkingblock;

import java.util.ArrayList;

public class ViewParkingblockActivity extends AppCompatActivity {

    ArrayList<Parkingblock> parkingblocks;
    LinearLayout linlay_parkingblockitems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_parkingblock);

        linlay_parkingblockitems = (LinearLayout) findViewById(R.id.viewparkingblock_linlay_parkingblockitems);

        parkingblocks = new ArrayList<>();
        parkingblocks.add(new Parkingblock());
        parkingblocks.get(0).setBlockname("HTL-Wels");
        parkingblocks.get(0).fillWithRandomSpots();

        fillLayout();
    }

    public void fillLayout(){
        for (Parkingblock iParkingblock : parkingblocks) {
            System.out.println("Dings\n\n\n\nDings");
            System.out.println(this);
            System.out.println(iParkingblock);
            ParkingblockItem pbi = new ParkingblockItem(this,iParkingblock);
            linlay_parkingblockitems.addView(pbi);
        }
    }
}