package com.willparken.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Parkingblock implements Serializable {
    private String blockname;
    private LinkedList<Parkingspot> parkingspots;

    public String getBlockname() {
        return blockname;
    }

    public void setBlockname(String blockname) {
        this.blockname = blockname;
    }

    public Parkingblock(LinkedList<Parkingspot> parkingspots, String blockname) {
        this.parkingspots = parkingspots;
        this.blockname = blockname;
    }

    public Parkingblock() {
        parkingspots = new LinkedList<>();
    }

    public void addParkingspot(Parkingspot iParkingspot){
        parkingspots.add(iParkingspot);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean reserveParkingspot(int parkingspotNr, LocalDateTime from, LocalDateTime until, User user){
        ParkingspotReservation reservation = new ParkingspotReservation(from,until,user);
        if (parkingspots.get(parkingspotNr-1).reserveSpot(reservation)){
            return true;
        }
        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public LinkedList<ParkingspotReservation> getReservationsForSpotInTimeRange(int parkingspotNr, LocalDateTime from, LocalDateTime until){
        return parkingspots.get(parkingspotNr-1).getReservationsInTimeRange(from,until);
    }

    public void fillWithRandomSpots(){
        for (int i = 0; i < 4; i++) {
            addParkingspot(new Parkingspot(i));
        }
    }

    @Override
    public String toString() {
        String reString = "Parkingblock - Name: "+getBlockname()+"\n";
        for (Parkingspot ps : parkingspots) {
            reString += ps.toString()+"\n";
        }
        return reString;
    }
}
