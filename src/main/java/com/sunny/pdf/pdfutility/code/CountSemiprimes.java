package com.sunny.pdf.pdfutility.code;

import java.util.Arrays;

public class CountSemiprimes {

    public int[] countSemiprimes(int n, int[] p, int[] q) {
            final int[] m = new int[n];
            int i = 2;
            // mark all non-prime numbers with minimal prime factor
            while ((long) i * (long) i <= n) {
                int k = i * i;
                while (k <= n) {
                    if (m[k - 1] == 0) {
                        m[k - 1] = i;
                    }
                    k += i;
                }
                i++;
            }
            // if number / it's minimal prime factor is not a prime number, unmark
            for (i = m.length - 1; i >= 0; i--) {
                if (m[i] > 0 && m[(i + 1) / m[i] - 1] != 0) {
                    m[i] = 0;
                }
            }
            // memorize number semiprimes from 0 to i
            int c = 0;
            for (i = 0; i < m.length; i++) {
                if (m[i] > 0) {
                    c++;
                }
                m[i] = c;
            }
            // calculate result for ranges
            final int[] result = new int[p.length];
            for (i = 0; i < p.length; i++) {
                final int from = p[i] - 1;
                final int to = q[i] - 1;
                if (from == 0) {
                    result[i] = m[to];
                } else {
                    result[i] = m[to] - m[from - 1];
                }
            }
            return result;

    }

    public static void main(String[] args) {
        CountSemiprimes solution = new CountSemiprimes();
        int N = 26;
        int[] P = {1, 4, 16};
        int[] Q = {26, 10, 20};
        int[] result = solution.countSemiprimes(N, P, Q);
        System.out.println(Arrays.toString(result)); // Output: [10, 4, 0]
    }
}
