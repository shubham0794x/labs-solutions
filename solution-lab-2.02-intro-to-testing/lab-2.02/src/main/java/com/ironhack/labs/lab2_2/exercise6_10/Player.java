package com.ironhack.labs.lab2_2.exercise6_10;

public abstract class Player {
    private int health;
    private int originalHealth;
    private int strength;
    private int lives;

    public Player(int health, int strength, int lives) {
        this.health = health;
        this.strength = strength;
        this.lives = lives;
        originalHealth = health;
    }

    public void decrementLive() {

        if (lives > 0) {
            lives--;
            health = originalHealth;
        } else {
            System.out.println("This character is dead");
        }
    }

    public void attack(Player playerToAttack) {

        playerToAttack.setHealth(playerToAttack.getHealth() - this.getStrength());
        playerToAttack.checkHealth();

    }

    public int checkHealth() {

        if (getHealth() <= 0) {
            decrementLive();
        }
        return getHealth();

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}
