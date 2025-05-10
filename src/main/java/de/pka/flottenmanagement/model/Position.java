package de.pka.flottenmanagement.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@IdClass(PositionId.class)
public class Position {
    
    @Id
    private float latitude;
    
    @Id
    private float longitude;

    @ManyToOne
    @JoinColumn
    private Mission mission;

    @OneToMany(mappedBy = "targetPosition", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RouteExecution> routeExecutions;

    public Position(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Position() {
    
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    @Override
    public String toString() {
        return "Position: " + "Latitude: "+ latitude + " Longitude: " + longitude;
    }
}
