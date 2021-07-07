package com.ironhack.lab2_4.classes;

import com.ironhack.lab2_4.utils.Validator;

import java.util.ArrayList;

public class PersonsList {
    private ArrayList<Person> persons;

    public PersonsList() {
        persons = new ArrayList<>();
    }

    public void add(Person person) {
        persons.add(person);
    }

    public void removeAll() {
        persons = new ArrayList<>();
    }

    public Person findByName(String name) {
        Validator.checkName(name);
        Person result = new Person();

        for (Person person : persons) {
            if (person.getName().equals(name)) {
                result = person;
                return result;
            }
        }

        throw new UnsupportedOperationException("Name not found");
    }



}
