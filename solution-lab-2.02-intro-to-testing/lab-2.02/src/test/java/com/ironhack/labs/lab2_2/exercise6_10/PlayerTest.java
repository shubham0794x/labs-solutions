package com.ironhack.labs.lab2_2.exercise6_10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {
    Player player1;
    Player player2;

    @BeforeEach
    void setUp() {
        player1 = new Wizard(100, 30, 3, 10);
        player2 = new Warrior(100, 20, 3, 10);
    }

    @Test
    void decrementLive_player1DecrementsLife_success() {
        player2.setHealth(0);
        player2.decrementLive();
        assertEquals(2, player2.getLives());
        assertEquals(100, player2.getHealth());

    }

    @Test
    void attack_player1reducesHealthPlayer2_success() {
        player1.attack(player2);
        assertEquals(70, player2.getHealth());
    }
    @Test
    void attack_player1KillsPlayer2_success() {
        player1.attack(player2);
        player1.attack(player2);
        player1.attack(player2);
        player1.attack(player2);
        assertEquals(100, player2.getHealth());
        assertEquals(2, player2.getLives());
    }

    @Test
    void checkHealth_healthReturnsCorrectValue() {
        assertEquals(100, player1.checkHealth());
    }
    @Test
    void checkHealth_healthReducesLivesIfHealthZero() {
        player1.setHealth(0);
        player1.checkHealth();
        assertEquals(2, player1.getLives());
        assertEquals(100, player1.getHealth());
    }

}