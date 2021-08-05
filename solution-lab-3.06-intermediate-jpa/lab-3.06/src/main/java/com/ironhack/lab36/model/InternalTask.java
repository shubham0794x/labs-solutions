package com.ironhack.lab36.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class InternalTask extends Task{

    public InternalTask(int id, String title, Date dueDate, boolean status) {
        super(id, title, dueDate, status);
    }

}
