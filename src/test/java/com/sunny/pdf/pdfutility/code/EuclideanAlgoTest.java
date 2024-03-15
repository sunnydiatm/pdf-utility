package com.sunny.pdf.pdfutility.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EuclideanAlgoTest {

    EuclideanAlgo euclideanAlgo = new EuclideanAlgo();

    @Test
    public void testCountChocolates() {

        assertEquals(5, euclideanAlgo.countChocolates(10, 4));
        assertEquals(1, euclideanAlgo.countChocolates(1, 2));
    }

    @Test
    public void testSolution() {
        int[] A1 = {15, 10, 3};
        int[] B1 = {75, 30, 9};
        assertEquals(1, euclideanAlgo.commonPrimeDivisors(A1, B1));

        int[] A2 = {1, 2, 3};
        int[] B2 = {2, 3, 4};
        assertEquals(2, euclideanAlgo.commonPrimeDivisors(A2, B2));
    }
}
