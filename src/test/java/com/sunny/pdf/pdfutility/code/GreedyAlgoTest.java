package com.sunny.pdf.pdfutility.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreedyAlgoTest {

    GreedyAlgo greedyAlgo = new GreedyAlgo();

    @Test
    public void testSolution() {

        int[] A1 = {1, 3, 7, 9, 9};
        int[] A2 = {5, 6, 8, 9, 10};
        assertEquals(3, greedyAlgo.maxNonOverlappingSegments(A1, A2));

    }

    @Test
    public void testSolution2() {

        int[] A1 = {1, 2, 3, 4, 1, 1, 3};
        assertEquals(3, greedyAlgo.tieRopes(4, A1));

    }

}
