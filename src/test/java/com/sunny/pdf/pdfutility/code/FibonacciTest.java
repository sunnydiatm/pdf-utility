package com.sunny.pdf.pdfutility.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciTest {

    Fibonacci fibonacci = new Fibonacci();

    @Test
    public void testMinJumps() {

        int[] A1 = {1, 1, 1, 0, 1, 0, 0, 1};
        assertEquals(2, fibonacci.minJumps(A1));

        int[] A2 = {0, 0, 0, 0, 0};
        assertEquals(-1, fibonacci.minJumps(A2));

        int[] A = {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};
        assertEquals(3, fibonacci.minJumps(A));
    }

    @Test
    public void testSolution() throws Exception {
        assertArrayEquals(new int[]{5, 1, 8, 0, 1}, new Fibonacci().ladder(new int[]{4, 4, 5, 5, 1}, new int[]{3, 2, 4, 3, 1}));
    }
}
