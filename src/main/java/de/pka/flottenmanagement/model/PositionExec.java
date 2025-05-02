package de.pka.flottenmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
public class PositionExec {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Id
    private float longitude;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeReached;
    private float positionDeviation;

    public PositionExec(float positionDeviation) {
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
