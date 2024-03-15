package com.sunny.pdf.pdfutility.code;

public class Fibonacci {

    public int minJumps(int[] a) {
        final int[] fib = new int[a.length < 2 ? 2 : a.length + 1];
        fib[0] = 1;
        fib[1] = 2;
        int fs = 2;
        while(fib[fs - 1] <= a.length) {
            fib[fs] = fib[fs - 1] + fib[fs - 2];
            fs++;
        }
        int result = -1;
        for (int i = 0; i <= a.length; i++) {
            if (i == a.length || a[i] == 1) {
                int min = Integer.MAX_VALUE;
                // O(log(n)) because it goes through Fibonacci numbers before n
                // And the number of them = O(log(n))
                for (int j = 0; j < fs && fib[j] <= i + 1; j++) {
                    final int from = i - fib[j];
                    if (from == -1) {
                        min = 1;
                    } else if (a[from] > 0) {
                        if (a[from] + 1 < min) {
                            min = a[from] + 1;
                        }
                    }
                }
                if (i < a.length) {
                    if (min == Integer.MAX_VALUE) {
                        a[i] = 0;
                    } else {
                        a[i] = min;
                    }
                } else {
                    if (min != Integer.MAX_VALUE) {
                        result = min;
                    }
                }
            }
        }
        return result;
    }

    public int[] ladder(int[] a, int[] b) {
        final int[] cn = new int[Math.max(a.length, 2)];
        cn[0] = 1;
        cn[1] = 2;
        // numbers of combinations are fibonacci numbers
        // if we take combinations for n - 2, we should add one 2 or two 1 to some places.
        // but any of these transformations are reduced to the following forms:
        // 1. combination from (n - 1) and 1
        // 2. combination from (n - 2) and 2
        // the same for n - 1. we can should add one 1 to some places.
        // it gives the same possible outcomes as in the previous case.
        // Hence the number of combination for n is number of combinations for n - 1 and n - 2
        // At the same time it cannot be less than this. Suppose it was.
        // Since all the combinations from n - 1 are appended only by 1 and for n - 2 by 2,
        // the parts from n - 1 and n - 2 are present only once maximum. In our case it means that some parts are missed.
        // but it also means, that we can add this part plus 1 or 2. Contraction.
        for (int i = 2; i < a.length; i++) {
            // we store values by mod 2**30.
            // we can do it because (x mod a + y mod a) mod a == (x + y) mod a
            //later they are easily converted to modulo by power of 2 by removing bits.
            // 0101 & 2**2 = 0101 & 0011
            cn[i] = (cn[i - 1] + cn[i - 2]) & ((1 << 30) - 1);
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = cn[a[i] - 1] & ((1 << b[i]) - 1);
        }
        return a;
    }
}
