package com.ironhack.lab36.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Name {
    private String firstName;
    private String middleName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Mr', 'Ms', 'Dr', 'None')")
    private Salutation salutation;

    public Name(String firstName, String middleName, String lastName, Salutation salutation) {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        setSalutation(salutation);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Salutation getSalutation() {
        return salutation;
    }

    public void setSalutation(Salutation salutation) {
        this.salutation = salutation;
    }

    public enum Salutation {
        Mr,
        Ms,
        Dr,
        None
    }
}
