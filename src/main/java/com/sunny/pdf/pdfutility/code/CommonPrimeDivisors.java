package com.sunny.pdf.pdfutility.code;

public class CommonPrimeDivisors {

    public int solution(int[] a, int[] b) {
        int c = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1 && b[i] == 1) {
                c++;
                continue;
            }
            // two numbers n and m may have the same set of prime factors only if
            // n / gcm and m / gcm contain only factors included into gcm
            // n / gcm and m / gcm don't contain the same factors or they'd be included to gcm
            final int g = gcm(a[i], b[i]); // no more than max(a[i]) or max(b[i])
            int m = a[i] / g; // no more than max(a[i])
            int gcm = g;
            boolean containsA = false;
            // the loop is performed no more than original gcm, so it's no more than max(a[i]) or max(b[i]) as well as max(a[i]) + max(b[i])
            while (true) {
                if (gcm % m == 0) {
                    containsA = true;
                    break;
                } else {
                    final int newG = gcm(gcm, m); // each one O(max(a[i]) + max(b[i]))
                    if (newG == 1) {
                        break;
                    }
                    m = m / newG;
                    gcm = newG;
                }
            }
            m = b[i] / g;
            gcm = g;
            boolean containsB = false;
            while (true) {
                if (gcm % m == 0) {
                    containsB = true;
                    break;
                } else {
                    final int newG = gcm(gcm, m);
                    if (newG == 1) {
                        break;
                    }
                    m = m / newG;
                    gcm = newG;
                }
            }
            if (containsA && containsB) {
                c++;
            }
        }
        return c;
    }

    private int gcm(final int a, final int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcm(b, a % b);
        }
    }

    public static void main(String[] args) {
        CommonPrimeDivisors divisors = new CommonPrimeDivisors();
        int[] arr1 = {15,10,3};
        int[] arr2 = {75,30,5};
        System.out.println(divisors.solution(arr1, arr2));
    }
}
