package com.sunny.pdf.pdfutility.code;

import java.util.Arrays;

public class Ladder {

    public int[] solution(int[] a, int[] b) {
        final int[] cn = new int[a.length < 2 ? 2 : a.length];
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

    public static void main(String[] args) {
        Ladder ladder = new Ladder();
        int[] arr1 = {4,4,5,5,1};
        int[] arr2 = {3,2,4,3,1};
        System.out.println(Arrays.toString(ladder.solution(arr1, arr2)));
    }
}
