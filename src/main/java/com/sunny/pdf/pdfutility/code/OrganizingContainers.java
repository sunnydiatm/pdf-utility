package com.sunny.pdf.pdfutility.code;

import java.util.List;

public class OrganizingContainers {

    public static String organizingContainers(List<List<Integer>> container) {
        int n = container.size();
        int[] totalBalls = new int[n];
        int[] containerCapacity = new int[n];

        // Calculate the total number of balls of each type and the total capacity of each container
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                totalBalls[j] += container.get(i).get(j);
                containerCapacity[i] += container.get(i).get(j);
            }
        }

        // Check if it's possible to perform the required swap operations
        for (int i = 0; i < n; i++) {
            boolean found = false;
            for (int j = i; j < n; j++) {
                if (totalBalls[i] == containerCapacity[j]) {
                    found = true;
                    swap(containerCapacity, i, j);
                    break;
                }
            }
            if (!found) {
                return "Impossible";
            }
        }

        return "Possible";
    }

    // Helper method to swap elements in an array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        List<List<Integer>> container = List.of(
                List.of(1, 3, 1),
                List.of(2, 1, 2),
                List.of(3, 3, 3)
        );
        System.out.println(organizingContainers(container));
    }
}

