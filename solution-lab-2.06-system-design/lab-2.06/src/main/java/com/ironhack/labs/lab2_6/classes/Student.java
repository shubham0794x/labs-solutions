package com.ironhack.labs.lab2_6.classes;

public class Student {
    private String name;
    private int grade;
    private boolean hasPassed;

    public Student(String name, int grade) {
        setName(name);
        setGrade(grade);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if (grade < 0) {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        } else if (grade > 100) {
            this.grade = 100;
            System.err.println("Grade can't be higher than 100. Grade for "
                    + getName() + " has been set to max (" + getGrade() + ")");
        } else {
            hasPassed = grade >= 50 ? true : false;
            this.grade = grade;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
