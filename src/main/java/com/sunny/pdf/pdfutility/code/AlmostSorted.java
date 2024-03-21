package com.sunny.pdf.pdfutility.code;

import java.util.ArrayList;
import java.util.List;

public class AlmostSorted {

    public static void almostSorted(List<Integer> arr) {
        int n = arr.size();
        List<Integer> sortedArr = new ArrayList<>(arr);
        sortedArr.sort(null); // Sort the array in ascending order

        // Check if the array is already sorted
        if (arr.equals(sortedArr)) {
            System.out.println("yes");
            return;
        }

        // Find the first and last indices where the array and sorted array differ
        int l = 0, r = n - 1;
        while (l < n && arr.get(l).equals(sortedArr.get(l))) {
            l++;
        }
        while (r >= 0 && arr.get(r).equals(sortedArr.get(r))) {
            r--;
        }

        // Check if swapping the elements will result in a sorted array
        boolean canSwap = true;
        for (int i = l + 1; i < r; i++) {
            if (!arr.get(i).equals(sortedArr.get(i))) {
                canSwap = false;
                break;
            }
        }

        // Check if reversing a subsegment will result in a sorted array
        boolean canReverse = true;
        for (int i = l, j = r; i <= j; i++, j--) {
            if (!arr.get(i).equals(sortedArr.get(j))) {
                canReverse = false;
                break;
            }
        }

        // Output the result
        if (canSwap) {
            System.out.println("yes");
            System.out.println("swap " + (l + 1) + " " + (r + 1));
        } else if (canReverse) {
            System.out.println("yes");
            System.out.println("reverse " + (l + 1) + " " + (r + 1));
        } else {
            System.out.println("no");
        }
    }

    public static void main(String[] args) {
        // Example usage
        List<Integer> arr = List.of(1, 5, 4, 3, 2, 6);
        almostSorted(arr);
    }
}
