package de.pka.flottenmanagement.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

/**
* Mission, die aus Abfolge mehrerer Positionen besteht und einem Mieter gehört
* 
* @author cdehnert18
* 
*/
@Entity
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    String shortName;
    
    String description;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MissionExecution> missionExecutions;
    
    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Position> positions;
    
    @ManyToOne
    @JoinColumn
    private Tenant tenant;

    public Mission() {
        this.shortName = "";
        this.description = "";
    }

    public Mission(String shortName, String description, Tenant tenant) {
        this.shortName = shortName;
        this.description = description;
        this.tenant = tenant;
    }

    public long getId() {
        return id;
    }

    public String getShortName() {
        return shortName;
    }
    
    public String getDescription() {
        return description;
    }
}