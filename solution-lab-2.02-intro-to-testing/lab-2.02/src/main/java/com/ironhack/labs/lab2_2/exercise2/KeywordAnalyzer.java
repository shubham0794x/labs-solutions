package com.ironhack.labs.lab2_2.exercise2;

public class KeywordAnalyzer {


    private static String[] keywords = {"abstract", "continue", "for", "new", "switch", "assert", "default", "goto", "package",
            "synchronized", "boolean", "do", "if", "private", "this", "break",
            "double", "implements", "protected", "throw", "byte", "else", "import", "public",
            "throws", "case", "enum", "instanceof", "return", "transient", "catch", "extends",
            "int", "short", "try", "char", "final", "interface", "static", "void", "class", "finally",
            "long", "strictfp", "volatile", "const", "float", "native", "super", "while"};

    public static boolean containsReservedKeyword(String string) {

        if (string == null) {
            return false;
        }

        for (String keyword : keywords) {
            if (string.toLowerCase().contains(keyword)) {
                return true;
            }
        }
        return false;

    }
}


