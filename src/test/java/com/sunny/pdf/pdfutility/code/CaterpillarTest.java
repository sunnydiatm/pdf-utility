package com.sunny.pdf.pdfutility.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaterpillarTest {

    Caterpillar caterpillar = new Caterpillar();

    @Test
    public void testSolution() {

        int[] A1 = {10, 2, 5, 1, 8, 12};
        assertEquals(4, caterpillar.countTriangles(A1));

        int[] A2 = {10, 2, 5, 1, 8, 12};
        assertEquals(4, caterpillar.countTriangles2(A2));
    }

    @Test
    public void testSolution2() {

        int[] A1 = {1, 4, -3};
        assertEquals(1, caterpillar.minAbsSumOfTwo(A1));

        int[] A2 = {-8, 4, 5, -10, 3};
        assertEquals(3, caterpillar.minAbsSumOfTwo(A2));

        int[] A3 = {1, 4, -3};
        assertEquals(1, caterpillar.minAbsSumOfTwo2(A3));

        int[] A4 = {-8, 4, 5, -10, 3};
        assertEquals(3, caterpillar.minAbsSumOfTwo2(A4));

    }

}
