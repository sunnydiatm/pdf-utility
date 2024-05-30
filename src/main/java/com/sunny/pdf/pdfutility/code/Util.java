package com.sunny.pdf.pdfutility.code;


import org.springframework.util.StringUtils;

import java.util.*;
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

       /* int[] A1 = {-5, -3, -1, 0, 3, 6, -6, 8};
        int a = absDistinct(A1);
        System.out.println("absDistinct=>" + a);*/

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

        /*int fac = factorial(5);
        System.out.println("factorial=>" + fac);*/

        //printTriangle(4);

        /*System.out.println("reverseString=" + reverseString("1234321"));*/

       /* int[] A1 = {1, 2, 3, 4, 6, 7, 9, 8, 10};
        System.out.println("getMissingElement=" +  getMissingElement(A1, 10));*/

        //printHash(6);

        //System.out.println(birthdayCakeCandles(List.of(4,4,1,3)));

        //System.out.println("Time conversion result=" + timeConversion("07:05:45PM"));

        int[] minMax = {-100, 2, 3, 4, 7000, 7, 9, 8, 10};
        findMinAndMaxElement(minMax);
    }

    public static int hurdleRace(int k, List<Integer> height) {
        // Write your code here

        int hurdleCount = 0;
        for (int i = 0; i < height.size(); i++) {
            if (height.get(i) > k) {
                int diff = height.get(i) - k ;
                if (hurdleCount < diff) {
                    hurdleCount = diff;
                }
            }
        }
        return hurdleCount;

    }

    public static void findMinAndMaxElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int j : arr) {
            if (max < j) {
                max = j;
            }
            if (min > j) {
                min = j;
            }
        }

        System.out.println("Min=" + min + " and Max=" + max);
    }

    public static List<Integer> climbingLeaderboard(List<Integer> al1, List<Integer> al2) {

        int[] scores = new int[al1.size()];
        int[] alice = new int[al2.size()];

        for (int i = 0; i < al1.size(); i++) {
            scores[i] = al1.get(i);
        }

        for (int i = 0; i < al2.size(); i++) {
            alice[i] = al2.get(i);
        }

        int n = scores.length;
        int m = alice.length;

        int res[] = new int[m];
        int[] rank = new int[n];

        rank[0] = 1;

        for (int i = 1; i < n; i++) {
            if (scores[i] == scores[i - 1]) {
                rank[i] = rank[i - 1];
            } else {
                rank[i] = rank[i - 1] + 1;
            }
        }

        for (int i = 0; i < m; i++) {
            int aliceScore = alice[i];
            if (aliceScore > scores[0]) {
                res[i] = 1;
            } else if (aliceScore < scores[n - 1]) {
                res[i] = rank[n - 1] + 1;
            } else {
                int index = binarySearch(scores, aliceScore);
                res[i] = rank[index];

            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < res.length ; i++) {
            int element = res[i];
            list.add(element);
        }
        return list;

    }

    private static int binarySearch(int[] a, int key) {

        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] < key && key < a[mid - 1]) {
                return mid;
            } else if (a[mid] > key && key >= a[mid + 1]) {
                return mid + 1;
            } else if (a[mid] < key) {
                hi = mid - 1;
            } else if (a[mid] > key) {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static String timeConversion(String s) {
        // Write your code here

        if (s.contains("AM")) {
            String begin = s.substring(0, 2);
            System.out.println("first two =" + begin);
            int beginInd = Integer.parseInt(begin);
            System.out.println("first two in integer=" + beginInd);
            if (beginInd < 12) {
                return s.replace("AM", "");
            } else if (beginInd == 12) {
                String a = s.replace("AM", "");
                return a.replace("12", "00");
            }

        } else if (s.contains("PM")) {
            String begin = s.substring(0, 2);
            System.out.println("first two =" + begin);
            int beginInd = Integer.parseInt(begin);
            System.out.println("first two in integer=" + beginInd);
            if (beginInd < 12) {
                String a = s.replace("PM", "");
                int res = beginInd + 12;
                return a.replace(begin, String.valueOf(res));
            } else if (beginInd == 12) {
                return s.replace("PM", "");
            }
        }

        return null;

    }

    public static void printHash(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1 ; j <= n; j++) {
               if ((i+j) > n) {
                   System.out.print("#");
               } else {
                   System.out.print(" ");
               }
            }
            System.out.println();
        }
    }

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here

        long sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int a : arr) {
            sum += a;
            if (a > max) {
                max = a;
            }
            if (a < min) {
                min = a;
            }
        }
        System.out.println((sum - max) + " " + (sum - min));

    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here

        int max = 0;
        int maxCount = 0;
        for (Integer candle : candles) {
            if (candle > max) {
                max = candle;
            }
        }

        System.out.println("max is=" + max);

        for (int i : candles) {
            if (max == i) {
                maxCount ++;
            }
        }

        System.out.println("Total max count=" + max);

        return maxCount;

    }



    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here

        int leftToRight = 0;
        int rightToLeft = 0;
        for (int i = 0; i < arr.size(); i ++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                if (i == j) {
                    leftToRight = leftToRight + arr.get(i).get(j);
                }
                if((i + j) == (arr.size() - 1)){
                    rightToLeft = rightToLeft + arr.get(i).get(j);
                }
            }
        }
        System.out.println(rightToLeft);
        return  leftToRight > rightToLeft ? leftToRight - rightToLeft : rightToLeft - leftToRight;
    }

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int size = arr.size();
        double positive = 0;
        double negative = 0;
        double zero = 0;
        for (int i : arr) {
            if (i > 0) {
                positive++;
            } else if (i < 0) {
                negative++;
            } else {
                zero++;
            }
        }

        System.out.println(positive/size);
        System.out.println(negative/size);
        System.out.println(zero/size);
    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        int alicePoint = 0;
        int bobPoint = 0;

        for (int i = 0; i < a.size(); i ++) {
            if (a.get(i) > b.get(i)) {
                alicePoint = alicePoint + 1;
            } else if (a.get(i) < b.get(i)) {
                bobPoint = bobPoint + 1;
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(alicePoint);
        result.add(bobPoint);
        return result;

    }

    public static int getMissingElement(int[] arr, int count) {
        if (arr.length == 0) {
            return -1;
        }

        Set<Integer> integerSet = new HashSet<>();

        for (int a : arr) {
            integerSet.add(a);
        }

        for (int i = 1; i <= arr.length; i++) {
            if (!integerSet.contains(i)) {
                return i;
            }
        }

        return -1;
    }


    public static String reverseString(String str) {

        char[] stringToCharArr = str.toCharArray();
        char[] temp = new char[stringToCharArr.length];
        int j =0;
        for (int i = stringToCharArr.length - 1 ; i >= 0  ; i--) {
            temp[j] = stringToCharArr[i];
            j++;
        }

        return String.valueOf(temp);

    }

    public static void printTriangle(int a) {

        for (int i = 0; i < a; i++) {
            for (int j = 0 ; j <= i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }

        System.out.println("reverse triangle");

        for (int i = 0; i < a; i++) {
            for (int j = 0 ; j < a - i; j++) {
                System.out.print(" * ");
            }

            System.out.println();
        }

        System.out.println("up side down symetrical triangle");

        for (int i = a; i > 0; i--) {
            for (int j = 0 ; j < a - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0 ; k < 2 * i - 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static int factorial(int a) {

        if (a ==0 || a==1) {
            return 1;
        }

        int factorial = 1;
        for (int i = 1 ; i <= a ; i++) {
            factorial = factorial * i;
        }

        return factorial;
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

