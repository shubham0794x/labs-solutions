package com.ironhack.exercise1.model;

import javax.persistence.*;

@Entity
@Table(name = "association")
public class Association {
    @Id
    private Integer id;

    private String name;

    public Association(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Association() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
