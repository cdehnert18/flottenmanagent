package de.pka.flottenmanagement.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class MissionExecution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn
    private Mission mission;

    /**
    * Nutzer, der Mission gestartet hat
    */
    @ManyToOne
    @JoinColumn
    private User user;

    /**
    * Ausgewähltes Fahrzeug für diese Mission
    */
    @OneToOne
    @JoinColumn(name = "ugv_id")
    private Ugv ugv;

    /**
    * Bereits ausgeführte Schritte des Fahrzeugs auf der Mission
    */
    @OneToMany(mappedBy = "missionExecution", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RouteExecution> routeExecutions;


    /**
     * Missionsstart
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    public MissionExecution() {

    }
}
