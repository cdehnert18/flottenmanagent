package de.pka.flottenmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Position {

    @Id
    private float latitude;
    @Id
    private float longitude;

    public Position(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }
}
