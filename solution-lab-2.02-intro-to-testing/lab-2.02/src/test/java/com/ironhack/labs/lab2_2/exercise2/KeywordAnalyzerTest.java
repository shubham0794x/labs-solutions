package com.ironhack.labs.lab2_2.exercise2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeywordAnalyzerTest {

    @Test
    void containsReservedKeyword_emptyString_returnsFalse() {
        assertEquals(false, KeywordAnalyzer.containsReservedKeyword(""));
    }

    @Test
    void containsReservedKeyword_null_returnsFalse() {
        assertEquals(false, KeywordAnalyzer.containsReservedKeyword(null));
    }

    @Test
    void containsReservedKeyword_findsFirstWord_returnsTrue() {
        assertEquals(true, KeywordAnalyzer.containsReservedKeyword("abstract methods are funny"));
        assertEquals(true, KeywordAnalyzer.containsReservedKeyword(" methods are funny abstract"));
    }
    @Test
    void containsReservedKeyword_findsLastWord_returnsTrue() {
        assertEquals(true, KeywordAnalyzer.containsReservedKeyword("while I wait..."));
        assertEquals(true, KeywordAnalyzer.containsReservedKeyword("I wait...while"));
    }

    @Test
    void containsReservedKeyword_lowerCaseUpperCase_returnsTrue() {
        assertEquals(true, KeywordAnalyzer.containsReservedKeyword("While I wait..."));
        assertEquals(true, KeywordAnalyzer.containsReservedKeyword("I wait...ABStract"));
    }




}