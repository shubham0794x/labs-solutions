package com.ironhack.airline.model;

import javax.persistence.*;

@Entity
@Table(name = "aircraft")
public class Aircraft {
    @Id
    @Column(name = "model")
    private String model;
    @Column(name = "seats")
    private Integer seats;

    public Aircraft() {
    }

    public Aircraft(String model, Integer seats) {
        this.model = model;
        this.seats = seats;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }
}
