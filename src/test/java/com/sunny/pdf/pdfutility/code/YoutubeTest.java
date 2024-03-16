package com.sunny.pdf.pdfutility.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YoutubeTest {

    Youtube youtube = new Youtube();

    @Test
    public void testSolution() {

        int[] A1 = {1, 0, 1, 1, 1};
        assertEquals(1, youtube.minimumCoinFlip(A1));

        int[] A2 = {1, 0, 1, 0, 1, 0};
        assertEquals(0, youtube.minimumCoinFlip(A2));
    }

    @Test
    public void testSolution2() {
        assertEquals(2, youtube.letterOccurrence("BAAABAB"));
        assertEquals(0, youtube.letterOccurrence("AAAA"));
        assertEquals(2, youtube.letterOccurrence("BBBAA"));
        assertEquals(0, youtube.letterOccurrence("BBBB"));

        assertEquals(3, youtube.letterOccurrence("BBBABAA"));
        assertEquals(0, youtube.letterOccurrence("AABBBB"));
    }

    @Test
    public void testSolution3() {

        assertEquals(5, youtube.smallestPositiveInteger(new int[]{1, 3, 6, 4, 1, 2}));
        assertEquals(1, youtube.smallestPositiveInteger(new int[]{-1, -3, -6}));
        assertEquals(4, youtube.smallestPositiveInteger(new int[]{1, 2, 3}));
    }
}
