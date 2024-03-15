package com.sunny.pdf.pdfutility.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimeAndCompositeTest {

    PrimeAndComposite primeAndComposite = new PrimeAndComposite();

    @Test
    public void testCountFactors() {
        assertEquals(8, primeAndComposite.countFactors(24));
        assertEquals(2, primeAndComposite.countFactors(13));
    }

    @Test
    public void testMinPerimeterRectangle() {
        assertEquals(22, primeAndComposite.minPerimeterRectangle(30));
        assertEquals(24, primeAndComposite.minPerimeterRectangle(36));
        assertEquals(4, primeAndComposite.minPerimeterRectangle(1));
    }

    @Test
    public void testMaxFlags() {

        int[] A2 = {1, 3, 2, 1, 0};
        assertEquals(1, primeAndComposite.maxFlags3(A2));

        int[] A1 = {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        assertEquals(3, primeAndComposite.maxFlags3(A1));
    }

    @Test
    public void testMaxBlocks() {

        int[] A1 = {1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2};
        assertEquals(3, primeAndComposite.maxBlocks2(A1));

        int[] A2 = {1, 2, 3, 4, 5};
        assertEquals(0, primeAndComposite.maxBlocks2(A2));
    }
}
