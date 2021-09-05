package com.ironhack.exercise2.model;

import com.ironhack.exercise2.enums.*;

import javax.persistence.*;

@Entity
public class Speaker extends Guest{

    private double duration;

    public Speaker(String name, Status status, double expertee) {
        super(name, status);
        this.duration = expertee;
    }

    public Speaker() {
        super();
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
