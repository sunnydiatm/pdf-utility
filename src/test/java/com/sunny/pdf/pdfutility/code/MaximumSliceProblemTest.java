package com.sunny.pdf.pdfutility.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumSliceProblemTest {

    MaximumSliceProblem maximumSliceProblem = new MaximumSliceProblem();

    @Test
    public void testFindMajorityIndex() {

        int[] nums1 = {23171, 21011, 21123, 21366, 21013, 21367};
        assertEquals(356, maximumSliceProblem.computeMaxEarning(nums1));
    }

    @Test
    public void testMaxSliceSum() {

        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, maximumSliceProblem.maxSliceSum(nums1));

        int[] nums2 = {1, 2, 3, 4, -10};
        assertEquals(10, maximumSliceProblem.maxSliceSum(nums2));

        int[] nums3 = {3, 2, -6, 4, 0};
        assertEquals(5, maximumSliceProblem.maxSliceSum(nums3));
    }

    @Test
    public void testMaxDoubleSliceSum() {

        int[] A1 = {3, 2, 6, -1, 4, 5, -1, 2};
        assertEquals(17, maximumSliceProblem.maxDoubleSliceSum(A1));

        int[] A2 = {5, 5, 5};
        assertEquals(0, maximumSliceProblem.maxDoubleSliceSum(A2));
    }
}
