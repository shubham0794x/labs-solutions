package com.ironhack.lab2_4.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonsListTest {

    Person person1;
    Person person2;
    Person person3;
    Person person4;
    PersonsList persons;

    @BeforeEach
    void init() {
        persons = new PersonsList();
        person1 = new Person("Jaume Sánchez", 31, "Programmer");
        person2 = new Person("Pepe Sánchez", 32, "Marketing Executive");
        person3 = new Person("Antonia Torres", 21, "HR Intern");
        person4 = new Person("José Pérez", 21, "Finance");
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);

    }

    @Test
    void findByName_nameExactlyMatches_OK() {
        assertEquals(person1, persons.findByName("Jaume Sánchez"));

    }

    @Test
    void findByName_nameWithoutAccent_throwsException() {
        assertThrows(UnsupportedOperationException.class, () -> persons.findByName("Jaume Sanchez"));

    }

    @Test
    void findByName_emptyList_throwsException() {
        persons.removeAll();
        assertThrows(UnsupportedOperationException.class, () -> persons.findByName("Jaume Sánchez"));
    }

    @Test
    void findByName_nameMultipleTimes_returnsFirst() {
        person4.setName("Jaume Sánchez");
        assertEquals(person1.getId(), persons.findByName("Jaume Sánchez").getId());
    }

}