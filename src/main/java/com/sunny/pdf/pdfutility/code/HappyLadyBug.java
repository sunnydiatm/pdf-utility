package com.sunny.pdf.pdfutility.code;

import java.util.HashMap;
import java.util.Map;

public class HappyLadyBug {

    public static String happyLadybugs(String b) {
        // Count the occurrence of each character
        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : b.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        // If any character (except underscore) occurs only once, it's impossible to make ladybugs happy
        for (char ch : countMap.keySet()) {
            if (ch != '_' && countMap.get(ch) == 1) {
                return "NO";
            }
        }

        // If there is at least one empty cell and all ladybugs are already happy, return YES
        if (countMap.containsKey('_')) {
            return "YES";
        }

        // If all ladybugs are already adjacent to at least one ladybug of the same color, return YES
        for (int i = 1; i < b.length() - 1; i++) {
            if (b.charAt(i) != b.charAt(i - 1) && b.charAt(i) != b.charAt(i + 1)) {
                return "NO";
            }
        }

        return "YES";
    }


    public static void main(String[] args) {
        System.out.println(happyLadybugs("RBY_YBR")); // Output: YES
        System.out.println(happyLadybugs("X_Y__X")); // Output: NO
        System.out.println(happyLadybugs("__")); // Output: YES
        System.out.println(happyLadybugs("B_RRBR")); // Output: NO
    }
}
