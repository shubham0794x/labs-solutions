package com.ironhack.labs.lab2_2.exercise1;

import java.util.ArrayList;
import java.util.List;

public class MathArray {

    public static int[] oddsToArray(int num) {
        int[] result = new int[0];
        int[] nextArray = new int[0];

        if (num <= 0) {
            throw new IllegalArgumentException();
        } else {
            for (int i = 1; i <= num; i++) {
                if (i % 2 != 0) {
                    nextArray = new int[result.length + 1];
                    for (int j = 0; j < result.length; j++) {
                        nextArray[j] = result[j];
                    }
                    nextArray[result.length] = i;
                }
                result = nextArray;
            }

        }

        return result;

    }

    public static int[] oddsToArrayDeprecated(int num) {
        List<Integer> arrayList = new ArrayList<>();
        int[] result;

        if (num <= 0) {
            throw new IllegalArgumentException();
        } else {
            for (int i = 1; i <= num; i++) {
                if (i % 2 != 0) {
                    arrayList.add(i);
                }
            }

        }
        result = new int[arrayList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = arrayList.get(i);
        }
        return result;

    }
}
