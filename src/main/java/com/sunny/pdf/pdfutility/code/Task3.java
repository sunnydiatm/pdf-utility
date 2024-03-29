package com.sunny.pdf.pdfutility.code;

import java.util.Collections;
import java.util.PriorityQueue;

public class Task3 {

/*
*
An industrial company has N factories, each producing some pollution every month. the company has decided to reduce the total fume emission by equipping some of the factories with one or more filters.
Every such filter reduces the pollution of a factory by half. When a second (or subsequent) filter is applied, it again reduces by half the remaining pollution emitted after fitting the existing filter.
For example, a factory that initially produces 6 unit of pollution will generate 3 unit with one filter, 1.5 unit with two filters and 0.75 with  the three filters
you're given an array of N integers describing the amount of pollution produced by the factories.  Your task is to find the minimum number of filters needed to decrease the total sum of pollution by at least half
Write a function using java
public int solution(int[] A);
which given an array A of length N, returns minimum number of filters needed to reduce the total pollution by at least half.
*
*/

    public static int minFiltersNeeded(int[] A) {
        int totalPollution = 0;

        for (int pollution : A) {
            totalPollution += pollution;
        }

        int targetPollution = totalPollution / 2;
        int result = 0;

        while (totalPollution > targetPollution) {
            int maxPollution = 0;
            int index = -1;

            for (int i = 0; i < A.length; i++) {
                if (A[i] > maxPollution) {
                    maxPollution = A[i];
                    index = i;
                }
            }

            A[index] = A[index] / 2;
            totalPollution = totalPollution - maxPollution / 2;
            result++;
        }

        return result;
    }

    public static int solution(int[] A) {
        int totalPollution = calculateTotalPollution(A);
        int targetPollution = totalPollution / 2;
        int filtersNeeded = 0;

        // Continue applying filters until the total pollution is less than or equal to half
        while (totalPollution > targetPollution) {
            // Apply filters to each factory
            for (int i = 0; i < A.length; i++) {
                if (A[i] % 2 == 1) {
                    A[i]--; // Reduce pollution by half
                    filtersNeeded++;
                }
                A[i] /= 2; // Apply filter
            }
            totalPollution = calculateTotalPollution(A); // Recalculate total pollution
        }
        return filtersNeeded;
    }

    // Helper method to calculate total pollution
    private static int calculateTotalPollution(int[] A) {
        int total = 0;
        for (int value : A) {
            total += value;
        }
        return total;
    }


    public static void main(String[] args) {
        int[] pollutionAmounts = {5, 19, 8, 1};
        int minFilters = pollution(pollutionAmounts);
        System.out.println(minFilters);

        int[] pollutionAmounts2 = {10,10};
        int minFilters2 = pollution(pollutionAmounts2);
        System.out.println(minFilters2);

        int[] pollutionAmounts3 = {3,0,5};
        int minFilters3 = pollution(pollutionAmounts3);
        System.out.println(minFilters3);

        /*int[] pollutionAmounts4 = {15, 19, 8, 1};
        int minFilters4 = pollution(pollutionAmounts4);
        System.out.println(minFilters4);

        int[] pollutionAmounts5 = {9, 6, 3, 1, 5};
        int minFilters5 = pollution(pollutionAmounts5);
        System.out.println(minFilters5);

        int[] pollutionAmounts6 = {6, 5, 3, 1, 4};
        int minFilters6 = pollution(pollutionAmounts6);
        System.out.println(minFilters6);

        int[] pollutionAmounts7 = {5, 4, 3, 1, 3};
        int minFilters7 = solution(pollutionAmounts7);
        System.out.println(minFilters7);*/
    }

    public static int pollution(int[] A) {

        if (A == null || A.length ==0 ) {
            return 0;
        }
        int filters = 0;
        int half = 0;
        int currSum = 0;
        int temp = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : A) {
            pq.add(i);
            half += i;
        }

        currSum = half;
        half = half / 2;

        while (currSum > half) {
            temp = pq.poll();
            currSum -= temp / 2;
            pq.add(temp / 2);
            filters++;
        }

        return filters;
    }


    public static int pollution2(double[] factories) {
        int filters = 0;
        double half = 0, currSum = 0, temp = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (double i : factories) {
            pq.add(i);
            half += i;
        }

        currSum = half;
        half = half / 2;

        while (currSum > half) {
            temp = pq.poll();
            currSum -= temp / 2;
            pq.add(temp / 2);
            filters++;
        }

        return filters;
    }

}
