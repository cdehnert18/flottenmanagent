package de.pka.flottenmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int routeId;
    String shortName;
    String description;

    public Route() {
        this.shortName="";
        this.description="";
    }

    public Route(String shortName,String description) {
        this.shortName=shortName;
        this.description=description;
    }

    public int getRouteId() {
        return routeId;
    }
    public String getShortName() {
        return shortName;
    }
    public String getDescription() {
        return description;
    }
}