package com.ironhack.labs.lab2_2.exercise6_10;

public class Elf extends Player {
    private int speed;

    public Elf(int health, int strength, int lives, int speed) {
        super(health, strength, lives);
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
