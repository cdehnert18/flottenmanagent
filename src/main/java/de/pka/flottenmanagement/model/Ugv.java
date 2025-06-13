package de.pka.flottenmanagement.model;

import de.pka.flottenmanagement.repository.PositionRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Ugv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    private float maxSpeed;
    
    private float batteryLevel;

    private float latitude;
  
    private float longitude;

    private Position

    @ManyToOne
    @JoinColumn
    private Tenant tenant;

    @OneToOne(optional = true, mappedBy = "ugv")
    @JoinColumn
    private MissionExecution missionExecution;

    public Ugv() {
        this.description = "";
        this.maxSpeed = 0;
        this.batteryLevel= 0;
        this.latitude = 0f;
        this.longitude = 0f;
    }

    public Ugv(String description, float maxSpeed, float batteryLevel) {
        this.description = description;
        this.maxSpeed = maxSpeed;
        this.batteryLevel = batteryLevel;
        this.latitude = 0f;
        this.longitude = 0f;
    }

    public Ugv(String description, float maxSpeed, float batteryLevel, Position position) {
        this.description = description;
        this.maxSpeed = maxSpeed;
        this.batteryLevel = batteryLevel;
        this.latitude = 0f;
        this.longitude = 0f;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }



    public float getBatteryLevel() {
        return batteryLevel;
    }

    public double getLatitude() { return latitude; }

    public double getLongitude() { return longitude; }

    @Override
    public String toString() {
        return "Id: " + id + " Tenant: "+ tenant + " Desc: " + description;
    }
}
