package com.Lock.Locker.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Locker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lockerNumber;
    private String type;
    private boolean isOccupied;
    private double rentalFee;
    private String insuranceDetails;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable =false)
    @JsonBackReference
    private Client client;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getLockerNumber() {
        return lockerNumber;
    }
    public void setLockerNumber(String lockerNumber) {
        this.lockerNumber = lockerNumber;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public double getRentalFee() {
        return rentalFee;
    }
    public void setRentalFee(double rentalFee) {
        this.rentalFee = rentalFee;
    }

    public String getInsuranceDetails() {
        return insuranceDetails;
    }
    public void setInsuranceDetails(String insuranceDetails) {
        this.insuranceDetails = insuranceDetails;
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
}
