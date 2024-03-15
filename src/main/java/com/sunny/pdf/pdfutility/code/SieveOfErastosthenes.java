package com.sunny.pdf.pdfutility.code;

import java.util.ArrayList;
import java.util.List;

public class SieveOfErastosthenes {

    public int[] countNonDivisible(int[] A) {
        int N = A.length;
        int maxVal = Integer.MIN_VALUE;

        // Find the maximum value in the array
        for (int num : A) {
            maxVal = Math.max(maxVal, num);
        }

        // Count the occurrences of each element
        int[] count = new int[maxVal + 1];
        for (int num : A) {
            count[num]++;
        }

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            int nonDivisors = N;
            for (int j = 1; j * j <= A[i]; j++) {
                if (A[i] % j == 0) {
                    nonDivisors -= count[j]; // Count divisors less than or equal to sqrt(A[i])
                    if (A[i] / j != j) {
                        nonDivisors -= count[A[i] / j]; // Count divisors greater than sqrt(A[i])
                    }
                }
            }
            result[i] = nonDivisors;
        }

        return result;
    }

    public int[] solution(int N, int[] P, int[] Q) { // todo - not working
        boolean[] sieve = new boolean[N + 1];
        List<Integer> semiprimes = new ArrayList<>();
        List<Integer> prefixCount = new ArrayList<>();
        int[] result = new int[P.length];

        // Sieve of Eratosthenes to find prime numbers up to N
        for (int i = 2; i * i <= N; i++) {
            if (!sieve[i]) {
                for (int j = i * i; j <= N; j += i) {
                    sieve[j] = true;
                }
            }
        }

        // Generate semiprime numbers
        for (int i = 2; i <= N; i++) {
            if (!sieve[i]) {
                for (int j = i; j <= N; j += i) {
                    if (!sieve[j / i]) {
                        semiprimes.add(j);
                    }
                }
            }
        }

        // Calculate prefix sum of semiprimes
        int count = 0;
        for (int i = 0; i <= N; i++) {
            if (semiprimes.contains(i)) {
                count++;
            }
            prefixCount.add(count);
        }

        // Count semiprimes in the given ranges
        for (int i = 0; i < P.length; i++) {
            result[i] = prefixCount.get(Q[i]) - prefixCount.get(P[i] - 1);
        }

        return result;
    }

    public int[] countSemiPrime(int N, int[] P, int[] Q) {
        int[] F = new int[N+1];
        int f = 2;
        while (f * f <= N) {
            if (F[f] == 0) {
                int K = f * f;
                while (K <= N) {
                    if (F[K] == 0) {
                        F[K] = f;
                    }
                    K += f;
                }
            }
            f += 1;
        }

        int M = P.length;
        int[] isSemiprime = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int start = P[i], end = Q[i];
            P[i] = 0;
            for (int j = start; j <= end; j++) {
                if (isSemiprime[j] == 0){       // has not been checked
                    isSemiprime[j] = -1;        // mark checked
                    // whether j is semiprime
                    if (F[j] > 0) {             // not prime, value of F[j] is the first prime divisor of number j
                        int x = j / F[j];
                        if (F[j / F[j]] == 0) {    // the second divisor is prime
                            isSemiprime[j] = 1; // mark semiprime
                        }
                    }
                }
                P[i] += isSemiprime[j] > 0 ? 1 : 0;
            }
        }

        return P;
    }

}
