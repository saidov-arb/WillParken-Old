package com.willparken.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Parkingspot implements Serializable {
    private int parkingspotNr;
    private LinkedList<ParkingspotReservation> reservations;

    public void setParkingspotNr(int parkingspotNr) {
        this.parkingspotNr = parkingspotNr;
    }

    public int getParkingspotNr() {
        return parkingspotNr;
    }

    public Parkingspot(int parkingspotNr) {
        this();
        this.parkingspotNr = parkingspotNr;
    }

    public Parkingspot() {
        reservations = new LinkedList<>();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean reserveSpot(ParkingspotReservation reservation) {
        boolean possible = true;
        for (ParkingspotReservation pr : reservations) {
            if (reservation.getFrom().isAfter(pr.getFrom()) && reservation.getFrom().isBefore(pr.getUntil()) ||
                    reservation.getUntil().isAfter(pr.getFrom()) && reservation.getUntil().isBefore(pr.getUntil()))
            {
                possible = false;
            }
        }
        if (possible) {
            reservations.add(reservation);
            return true;
        }
        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public LinkedList<ParkingspotReservation> getReservationsInTimeRange(LocalDateTime from, LocalDateTime until){
        LinkedList<ParkingspotReservation> reReservations = new LinkedList<>();

        for (ParkingspotReservation pr : reservations) {
            if (from.isAfter(pr.getFrom()) && from.isBefore(pr.getUntil()) ||
                    until.isAfter(pr.getFrom()) && until.isBefore(pr.getUntil()))
            {
                reReservations.add(pr);
            }
        }

        return reReservations;
    }

    @Override
    public String toString() {
        String reString = "ParkingSpot - Nr: "+getParkingspotNr()+"\n";

        for (ParkingspotReservation pr : reservations) {
            reString += pr.toString()+"\n";
        }

        return reString;
    }
}
