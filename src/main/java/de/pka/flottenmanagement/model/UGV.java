package de.pka.flottenmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UGV {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ugvId;
    private String description;
    private int maxSpeed;
    private int batteryLevel;

    public UGV() {
        this.description = "";
        this.maxSpeed = 0;
        this.batteryLevel= 0;
    }

    public UGV(String description, int maxSpeed, int batteryLevel) {
        this.description = description;
        this.maxSpeed = maxSpeed;
        this.batteryLevel = batteryLevel;
    }

    public int getUgvId() {
        return ugvId;
    }

    public String getDescription() {
        return description;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }
}
