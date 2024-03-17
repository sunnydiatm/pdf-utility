package com.sunny.pdf.pdfutility.code;

import java.util.ArrayList;
import java.util.List;

public class ClimbingTheLeaderboard {

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

        int[] res = new int[m];
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
            list.add(res[i]);
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

    public static List<Integer> climbingLeaderboard2(List<Integer> al1, List<Integer> al2) {

        /*int[] scores = new int[al1.size()];
        int[] alice = new int[al2.size()];

        for (int i = 0; i < al1.size(); i++) {
            scores[i] = al1.get(i);
        }

        for (int i = 0; i < al2.size(); i++) {
            alice[i] = al2.get(i);
        }*/

        int n = al1.size();
        int m = al2.size();

        int[] rank = new int[n];
        rank[0] = 1;
        for (int i = 1; i < n; i++) {
            if (al1.get(i) == al1.get(i - 1)) {
                rank[i] = rank[i - 1];
            }
            else {
                rank[i] = rank[i - 1] + 1;
            }
        }

        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int aliceScore = al2.get(i);
            if (aliceScore > al1.get(0)) {
                res[i] = 1;
            } else if (aliceScore < al1.get(n-1)) {
                res[i] = rank[n - 1] + 1;
            } else {
                int index = binarySearch2(al1, aliceScore);
                res[i] = rank[index];
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < res.length ; i++) {
            list.add(res[i]);
        }
        return list;

    }

    private static int binarySearch2(List<Integer> list, int key) {
        int[] a = new int[list.size()];

        for (int i = 0; i < list.size() - 1; i++) {
            a[i] = list.get(i);
        }
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
}
