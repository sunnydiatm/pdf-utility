package com.sunny.pdf.pdfutility.code;

public class EuclideanAlgo {

    public int countChocolates(int N, int M) {
        // Calculate the greatest common divisor of N and M
        int gcd = gcd(N, M);

        // Calculate the number of chocolates eaten
        return N / gcd;
    }

        public int commonPrimeDivisors(int[] A, int[] B) {
            int count = 0;

            for (int i = 0; i < A.length; i++) {
                if (hasSamePrimeDivisors(A[i], B[i])) {
                    count++;
                }
            }

            System.out.println("count => " + count);
            return count / 2 ; //because of pair
        }

        private boolean hasSamePrimeDivisors(int A, int B) {
            int gcdValue = gcd(A, B);

            while (A != 1) {
                int gcdA = gcd(A, gcdValue);
                if (gcdA == 1) {
                    break;
                }
                A /= gcdA;
            }

            if (A != 1) {
                return false;
            }

            while (B != 1) {
                int gcdB = gcd(B, gcdValue);
                if (gcdB == 1) {
                    break;
                }
                B /= gcdB;
            }

            return B == 1;
        }

        private int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }

}
