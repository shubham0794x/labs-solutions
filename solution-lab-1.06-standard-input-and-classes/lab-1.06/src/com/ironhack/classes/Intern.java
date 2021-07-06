package com.ironhack.classes;

public class Intern extends Employee {
    private final int MAX_SALARY = 20000;

    public Intern(String name, String email, int age, int salary) {
        super(name, email, age, salary);
    }

    @Override
    public void setSalary(int salary) {
        salary = salary > MAX_SALARY ? MAX_SALARY : salary;
        super.setSalary(salary);
    }
}
