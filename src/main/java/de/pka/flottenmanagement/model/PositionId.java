package de.pka.flottenmanagement.model;

import java.io.Serializable;
import java.util.Objects;

public class PositionId implements Serializable{
    
    private float latitude;
    
    private float longitude;

    public PositionId() {
        
    }

    public PositionId(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PositionId that = (PositionId) obj;
        return Float.compare(that.latitude, latitude) == 0 &&
               Float.compare(that.longitude, longitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }
}
