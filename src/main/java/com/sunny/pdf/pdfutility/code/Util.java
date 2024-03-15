package com.sunny.pdf.pdfutility.code;


import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Util {

    public static void main(String[] args) {
        /*boolean result = isPalindrome("121");
        System.out.println("isPalindrome => " + result);*/

        /*boolean result = isPrimeNumber(7);
        System.out.println("isPrimeNumber => " + result);*/

        /*int a = gcd (8, 12);
        System.out.println("gcd=" + a);*/

        /*int result = fibonacci(10);
        System.out.println("Fibonacci Result=>" + result);*/

        int[] A1 = {-5, -3, -1, 0, 3, 6, -6, 8};
        int a = absDistinct(A1);
        System.out.println("absDistinct=>" + a);

       /* int rows = 4;
        int column = 4;
        int[][] arr = new int[rows][column];

        int value = 1;
        for(int i = 0 ; i < rows ; i++) {
            for (int j = 0; j < column; j++) {
                arr[i][j] = value;
                value++;
            }
        }

        for(int i = 0 ; i < rows ; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }*/

    }

    public static boolean isPalindrome(String str) {
        System.out.println("input String = " + str);
        char[] palindromeArr = str.toCharArray();
        char[] tempArr = new char[palindromeArr.length];

        int j = 0;

        for (int i = palindromeArr.length - 1 ; i >= 0 ; i--) {
            tempArr[j] = palindromeArr[i];
            j++;
        }

        System.out.println("output array =" + Arrays.toString(tempArr));
        String output = Arrays.toString(tempArr);
        System.out.println("output String =" + output);

        return Arrays.equals(palindromeArr, tempArr);
    }

    public static boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2 ; i < number / 2 ; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public static int fibonacci(int length) {
        int a = 0;
        int b = 1;
        for (int i = 0 ; i < length ; i++) {
            System.out.print(a + " ");
            int sum = a + b;
            a = b ;
            b = sum ;
        }

        //System.out.println("b=>" + b);
        return b;
    }

    public static int absDistinct(int[] arr) {
        Set<Integer> integerSet = new HashSet<>();

        for (int a : arr) {
            integerSet.add(a);
        }

        System.out.println("Before abs size=>" + integerSet.size());

        Set<Integer> absSet = integerSet.stream().map(Math::abs).collect(Collectors.toSet());

        System.out.println("AFTER abs size=>" + absSet.size());

        return absSet.size();
    }

    public int minimumCoinFlip(int[] A) {
        int flipsStartWithHeads = 0;
        int flipsStartWithTails = 0;

        // Case 1: Starting with heads (H)
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0 && A[i] == 1) {
                flipsStartWithHeads++;
            } else if (i % 2 == 1 && A[i] == 0) {
                flipsStartWithHeads++;
            }
        }

        // Case 2: Starting with tails (T)
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0 && A[i] == 0) {
                flipsStartWithTails++;
            } else if (i % 2 == 1 && A[i] == 1) {
                flipsStartWithTails++;
            }
        }

        return Math.min(flipsStartWithHeads, flipsStartWithTails);
    }

}

