package com.ironhack.labs.lab2_2.exercise6_10;

public class Warrior extends Player {
    private int force;

    public Warrior(int health, int strength, int lives, int force) {
        super(health, strength, lives);
        this.force = force;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public Elf convertToElf() {
        return new Elf(getHealth(), getStrength(), getLives(), getForce());
    }
}
