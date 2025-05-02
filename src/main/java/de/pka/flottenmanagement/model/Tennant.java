package de.pka.flottenmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Tennant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tennantId;

    public Tennant() {}

    public int getTennantId() {
        return tennantId;
    }
}