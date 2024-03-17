package com.sunny.pdf.pdfutility.code;

import org.springframework.util.StringUtils;

public class AppendAndDelete {

    public static String appendAndDelete(String s, String t, int k) {

        if (s == null || t == null) {
            return "No";
        }
        // Write your code here
        if (s.equals(t)) {
            return "Yes";
        }

        if (s.length() + t.length() <= k) {
            return "Yes";
        }

        int i = 0; // represents index of 1st non-matching character
        for (   ; i < s.length() && i < t.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                break;
            }
        }

        int minOperations = (s.length() - i) + (t.length() - i);

        return k >= minOperations && (k - minOperations) % 2 == 0 ? "Yes" : "No";

    }

    public static void main(String[] args) {
        System.out.println(appendAndDelete("hackerhappy", "hackerrank", 9));
    }
}
