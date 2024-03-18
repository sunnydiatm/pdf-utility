package com.sunny.pdf.pdfutility.code;

import java.util.Arrays;

public class RotateArray {

    public static int[] rotateRight(int[] nums, int k) {
        int n = nums.length;
        int[] rotated = new int[n];
        int steps = k % n;
        System.out.println("step=" + steps);

        for (int i = 0; i < n; i++) {
            System.out.println("(i + steps) % n=" + (i + steps) % n);
            rotated[(i + steps) % n] = nums[i];
        }

        return rotated;
    }
    public static int[] rotateLeft(int[] nums, int k) {
        int n = nums.length;
        int[] rotated = new int[n];
        int steps = k % n;
        System.out.println("step=" + steps);
        for (int i = 0; i < n; i++) {
            System.out.println("i - steps + n) % n=" + (i - steps + n) % n);
            rotated[(i - steps + n) % n] = nums[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        System.out.println(1 % 10);
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;

        int[] rotated = rotateRight(nums, k);
        System.out.println("Original array: " + Arrays.toString(nums));
        System.out.println("Rotated array: " + Arrays.toString(rotated));

        int[] rotatedLeft = rotateLeft(nums, k);
        System.out.println("Original array: " + Arrays.toString(nums));
        System.out.println("Rotated array: " + Arrays.toString(rotatedLeft));
    }
}

