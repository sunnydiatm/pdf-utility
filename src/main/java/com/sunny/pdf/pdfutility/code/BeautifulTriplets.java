package com.sunny.pdf.pdfutility.code;

import java.util.List;

public class BeautifulTriplets {

    public static int beautifulTriplets2(int d, List<Integer> arr) {
        int count = 0;
        int n = arr.size();

        // Iterate over the elements of the array
        for (int i = 0; i < n - 2; i++) {
            int first = arr.get(i);
            // Check if arr[i] + d and arr[i] + 2d exist in the array
            if (arr.contains(first + d) && arr.contains(first + 2 * d)) {
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        int d = 3;
        List<Integer> arr = List.of(1, 2, 4, 5, 7, 8, 10);
        System.out.println(beautifulTriplets2(d, arr));
    }
}

