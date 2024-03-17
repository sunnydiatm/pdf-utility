package com.sunny.pdf.pdfutility.code;

public class BiggerIsGreater {

    public static String biggerIsGreater(String w) {
        char[] chars = w.toCharArray();
        int n = chars.length;

        // Step 1: Find the first character w[i] that is smaller than the character to its right
        int i = n - 2;
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }

        // If no such character exists, return "no answer"
        if (i == -1) {
            return "no answer";
        }

        // Step 2: Find the smallest character w[j] to the right of w[i] such that w[j] is greater than w[i]
        int j = n - 1;
        while (chars[j] <= chars[i]) {
            j--;
        }

        // Step 3: Swap w[i] and w[j]
        swap(chars, i, j);

        // Step 4: Reverse the substring to the right of w[i]
        reverse(chars, i + 1, n - 1);

        return new String(chars);
    }

    // Helper method to swap two characters in the char array
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    // Helper method to reverse a substring in the char array
    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String w = "dkhc";
        System.out.println(biggerIsGreater(w));
    }
}

