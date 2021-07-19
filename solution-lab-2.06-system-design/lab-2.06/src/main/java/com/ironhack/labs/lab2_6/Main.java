package com.ironhack.labs.lab2_6;

import com.ironhack.labs.lab2_6.classes.Student;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("Jaume", 60);
        Student student2 = new Student("Alejandro", 50);
        Student student3 = new Student("Celia", 96);
        Student student4 = new Student("Julia", 35);

        HashMap<String, Student> studentHashMap = new HashMap<>();
        studentHashMap.put(student1.getName(), student1);
        studentHashMap.put(student2.getName(), student2);
        studentHashMap.put(student3.getName(), student3);
        studentHashMap.put(student4.getName(), student4);

        studentHashMap.values().forEach(System.out::println);

        System.out.println("Increase grades: ");

        studentHashMap = increaseGrades(studentHashMap);
        studentHashMap.values().forEach(System.out::println);


    }

    private static HashMap<String, Student> increaseGrades(HashMap<String, Student> studentHashMap) {

        HashMap<String, Student> result = new HashMap<>();

        studentHashMap.values().forEach(student -> {
            student.setGrade((int) (student.getGrade() * 1.10));
            result.put(student.getName(), student);
        });
        return result;
    }

}
