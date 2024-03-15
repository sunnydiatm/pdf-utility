package com.sunny.pdf.pdfutility.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilTest {
    Util util = new Util();

    @Test
    public void testSolution() {

        int[] A1 = {1, 0, 1, 1, 1};
        assertEquals(1, util.minimumCoinFlip(A1));

        int[] A2 = {1, 0, 1, 0, 1, 0};
        assertEquals(0, util.minimumCoinFlip(A2));
    }
}
