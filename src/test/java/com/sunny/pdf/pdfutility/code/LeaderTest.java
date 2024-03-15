package com.sunny.pdf.pdfutility.code;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeaderTest {

    Leader leader = new Leader();

    @Test
    public void testFindMajorityIndex() {

        int[] nums1 = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        assertEquals(8, leader.findMajorityIndex(nums1));

        int[] nums2 = {3, 3, 4, 2, 4, 4, 2, 4};
        assertEquals(-1, leader.findMajorityIndex(nums2));

        int[] nums3 = {3, 4, 3, 2, 3, -1, 3, 3};
        assertTrue(List.of(0,2,4,6,7).contains(leader.findMajorityIndex(nums3)));
    }

    @Test
    public void testEquiLeader() {

        int[] A1 = {4, 3, 4, 4, 4, 2};
        assertEquals(2, leader.equiLeader(A1));

        int[] A2 = {4, 4, 2, 5, 3, 4, 4, 4};
        assertEquals(3, leader.equiLeader(A2));
    }
}
