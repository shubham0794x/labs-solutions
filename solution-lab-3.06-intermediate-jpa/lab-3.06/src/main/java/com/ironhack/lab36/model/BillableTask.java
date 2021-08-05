package com.ironhack.lab36.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class BillableTask extends Task{
    private int hourlyRate;

    public BillableTask(int id, String title, Date dueDate, boolean status, int hourlyRate) {
        super(id, title, dueDate, status);
        this.hourlyRate = hourlyRate;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
