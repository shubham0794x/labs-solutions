package com.ironhack.exercise2.model;

import javax.persistence.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;

@Entity
public class Expositions extends Event{
    public Expositions(Integer id, Date date, Integer duration, String location, String title, List<Guest> guests) {
        super(id, date, duration, location, title, guests);
    }

    public Expositions() {
    }

    public Expositions(Date date, Integer duration, String location, String title) {
        super(date, duration, location, title);
    }
}
