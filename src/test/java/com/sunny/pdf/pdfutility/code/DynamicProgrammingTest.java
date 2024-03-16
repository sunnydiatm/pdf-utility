package com.sunny.pdf.pdfutility.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicProgrammingTest {

    DynamicProgramming dynamicProgramming = new DynamicProgramming();

    @Test
    public void testSolution() {

        int[] A1 = {1, -2, 0, 9, -1, -2};
        assertEquals(8, dynamicProgramming.numberSolitaire(A1));

    }

    @Test
    public void testSolution2() {

        int[] A1 = {1, 5, 2, -2};
        assertEquals(0, dynamicProgramming.minAbsSum(A1));

    }

}
