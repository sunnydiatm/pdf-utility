package com.sunny.pdf.pdfutility.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SieveOfErastosthenesTest {

    SieveOfErastosthenes sieveOfErastosthenes = new SieveOfErastosthenes();

    @Test
    public void testCountNonDivisible() {

        int[] A1 = {3, 1, 2, 3, 6};
        assertArrayEquals(new int[]{2, 4, 3, 2, 0}, sieveOfErastosthenes.countNonDivisible(A1));

        int[] A2 = {1, 2, 3, 4, 5};
        assertArrayEquals(new int[]{4, 4, 4, 4, 4}, sieveOfErastosthenes.countNonDivisible(A2));
    }

    @Test
    public void testCountSemiPrime() {

        int[] P1 = {1, 4, 16};
        int[] Q1 = {26, 10, 20};
        assertArrayEquals(new int[]{10, 4, 0}, sieveOfErastosthenes.countSemiPrime(26, P1, Q1));

    }


}
