package de.pka.flottenmanagement.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


/**
* Mieter (z.B. Firma), die mehrere Nutzer (User) enthält
* 
* @author cdehnert18
* 
*/
@Entity
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
    * Missionen, die dem Mieter gehören und allen zugehörigen Nutzern verfügbar sein sollten
    */
    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mission> missions;

    /**
    * Nutzer, die dem Mieter zugehörig sind
    */
    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users;
    
    /**
    * UGV's, die dem Mieter zugehörig sind
    */
    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ugv> ugvs;

    public Tenant() {

    }

    public long getId() {
        return id;
    }
}