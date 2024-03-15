package com.sunny.pdf.pdfutility.code;


import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Util {

    public static void main(String[] args) {
        /*boolean result = isPalindrome("121");
        System.out.println("isPalindrome => " + result);*/

        /*boolean result = isPrimeNumber(7);
        System.out.println("isPrimeNumber => " + result);*/

        /*int a = gcd (8, 12);
        System.out.println("gcd=" + a);*/

        int result = fibonacci(10);
        System.out.println("Fibonacci Result=>" + result);
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

}

