package de.pka.flottenmanagement.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;

@Entity
public class RouteExecution {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private float currentLatitude;
    
    private float currentLongitude;
    
    private Date timeReached;

    private float positionDeviation;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "position_latitude", referencedColumnName = "latitude"),
        @JoinColumn(name = "position_longitude", referencedColumnName = "longitude")
    })
    private Position targetPosition;

    @ManyToOne
    @JoinColumn
    private MissionExecution missionExecution;

    public RouteExecution(float positionDeviation) {
        this.timeReached = new Date(System.currentTimeMillis());
        this.positionDeviation = positionDeviation;
    }

    public Date getTimeReached() {
        return timeReached;
    }

    public float getPositionDeviation() {
        return positionDeviation;
    }
}
