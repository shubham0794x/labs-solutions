package com.ironhack.labs.lab2_2.exercise6_10;

public class Main {
    public static void main(String[] args) {
        Warrior player1 = new Warrior(100,100,3, 60);
        Elf player2 = player1.convertToElf();
    }
}
