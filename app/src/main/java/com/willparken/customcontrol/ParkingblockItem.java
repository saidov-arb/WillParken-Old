package com.willparken.customcontrol;

import android.content.Context;
import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.willparken.R;
import com.willparken.control.ParkingspotSearchMaskActivity;
import com.willparken.model.Parkingblock;

public class ParkingblockItem extends ConstraintLayout{

    private TextView txt_parkingblockTitle, txt_parkingblockDescription;
    private LinearLayout linlay_parkingblockItem;

    private Parkingblock iParkingblock;

    private Intent intentSearchMask;



    public ParkingblockItem(@NonNull Context context, @NonNull Parkingblock paramParkingblock) {
        super(context);
        inflate(getContext(), R.layout.parking_block_item,this);

        iParkingblock = paramParkingblock;

        txt_parkingblockTitle = (TextView) findViewById(R.id.pbi_txt_parkingblocktitle);
        txt_parkingblockDescription = (TextView) findViewById(R.id.pbi_txt_parkingblockdescription);
        linlay_parkingblockItem = (LinearLayout) findViewById(R.id.pbi_container_parkingblockitem);

        intentSearchMask = new Intent(this.getContext(), ParkingspotSearchMaskActivity.class);

        linlay_parkingblockItem.setOnClickListener(view -> {
            this.getContext().startActivity(intentSearchMask);
        });

        setTitleDescription();
    }

    public void setTitleDescription(){
        txt_parkingblockTitle.setText(String.valueOf(iParkingblock.getBlockname()));
        txt_parkingblockDescription.setText(String.valueOf("Parkingspots: "+iParkingblock.getParkingSpotAmount()));
    }
}