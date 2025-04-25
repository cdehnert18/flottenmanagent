package de.pka.flottenmanagement.model;

import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

public class PositionExec {

    @Id
    private Position position;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeReached;
    private float positionDeviation;

    public PositionExec(Position position, float positionDeviation) {
        this.position = position;
        this.timeReached = new Date(System.currentTimeMillis());
        this.positionDeviation = positionDeviation;
    }

    public Position getPosition() {
        return position;
    }

    public Date getTimeReached() {
        return timeReached;
    }

    public float getPositionDeviation() {
        return positionDeviation;
    }

}
