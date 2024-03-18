package com.sunny.pdf.pdfutility.code;

import java.util.List;

public class JumpingOnTheClouds {

    public int jumpingOnCloudsRevisited(int[] c, int k) {
        int E = 100;
        int position = 0;
        int n = c.length;
        do {
            position = (position + k) % n;
            if (c[position] == 1) {
                E -= 2;
            }
            E--;
        } while (position != 0);

        return E;
    }

    public int jumpingOnClouds(int[] c) {
        /* Jump on clouds */
        int jumps = 0;
        int i     = 0;
        int n = c.length;
        while (i < n - 1) {
            if (i + 2 < n && c[i + 2] == 0) {
                i += 2;
            } else {
                i++;
            }
            jumps++;
        }
        return jumps;
    }

    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        int jumps = 0;
        int i     = 0;
        int n = c.size();
        while (i < n - 1) {
            if (i + 2 < n && c.get(i + 2) == 0) {
                i += 2;
            } else {
                i++;
            }
            jumps++;
        }
        return jumps;

    }
}
