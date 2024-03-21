package com.sunny.pdf.pdfutility.code;

public class MinMaxDivision {

    public int solution(int k, int m, int[] a) {
        // look for max value. it may be less than m
        // the result cannot be less than m
        // count the sum. the result cannot be more than the sum
        // O(n)
        int max = 0;
        int sum = 0;
        for (final int value : a) {
            if (value > max) {
                max = value;
            }
            sum += value;
        }
        // two trivial cases. if k is 1, then all the elements inside one group
        if (k == 1) {
            return sum;
        }
        // if k is more than number of elements, some of them may be empty
        // but all the elements may be split to the groups of 1 element
        // large sum will be equal to max element value
        if (k >= a.length) {
            return max;
        }
        // the result is somewhere between max(n) and sum(n)
        // use binary search to find the correct one
        // max value of sum is n * m, max(n) can be 0 if all the elements are 0
        // so at most we perform binary search on the interval from 0 to n * m
        // which is O(log(n * m))
        int begin = max;
        int end = sum;
        int result = sum;
        // O(n * log(m * n)) in total
        while (begin <= end) {
            int medium = (begin + end) / 2;
            if (isDivisible(a, medium, k)) {
                result = medium;
                end = medium - 1;
            } else {
                begin = medium + 1;
            }
        }
        return result;
    }

    // O(n)
    private boolean isDivisible(final int[] a, final int size, final int k) {
        int sum = 0;
        int stepsLeft = k - 1; // first is started already
        for (final int value : a) {
            sum += value;
            if (sum > size) {
                sum = value;
                stepsLeft--; // start a new step
            }
        }
        return stepsLeft >= 0;
    }

    public static void main(String[] args) {
        MinMaxDivision minMaxDivision = new MinMaxDivision();
        int[] arr = {2,1,5,1,2,2,2};
        System.out.println(minMaxDivision.solution(3,5, arr));
    }
}
