package com.willparken.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ParkingspotReservation implements Serializable {
    private LocalDateTime from,until;
    private User user;

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getUntil() {
        return until;
    }

    public User getUser() {
        return user;
    }

    public ParkingspotReservation(LocalDateTime from, LocalDateTime until, User user) {
        this.from = from;
        this.until = until;
        this.user = user;
    }

    @Override
    public String toString() {
        return "from=" + getFrom() +
                ", until=" + getUntil() +
                ", user="+getUser().getEmail();
    }
}
