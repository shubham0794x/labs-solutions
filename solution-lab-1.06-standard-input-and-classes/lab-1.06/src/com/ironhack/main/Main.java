package com.ironhack.main;

import com.ironhack.classes.Employee;
import com.ironhack.classes.Intern;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<Employee> employees = Arrays.asList(
            new Employee("John Doe", "jdoe@ironhack.com", 10, 30000),
            new Intern("John Doe Jr", "jdoejr@ironhack.com", 10, 30000),
            new Employee("Mary Doe", "mdoe@ironhack.com", 66, 70000),
            new Intern("Mary Doe Jr", "mdoejr@ironhack.com", 55, 40000),
            new Employee("Fernando Doe", "fdoe@ironhack.com", 20, 33000),
            new Employee("Yolanda Doe", "ydoe@ironhack.com", 17, 22000),
            new Employee("Juan Doe", "jdoe@ironhack.com", 60, 52000),
            new Employee("Nick Doe", "ndoe@ironhack.com", 16, 39000),
            new Employee("Anibal Doe", "adoe@ironhack.com", 33, 26000),
            new Employee("Hanna Doe", "hdoe@ironhack.com", 20, 30000)
        );

        // Open the file to be written in
        FileWriter writer = new FileWriter("employees.txt", true);

        // Iterate over the file
        for(Employee employee : employees) {
            // Print on the file
            writer.write(employee.toString() + "\n");
        }

        // Close buffer
        writer.close();

    }

}
