package com.sunny.pdf.pdfutility.code;

import java.util.ArrayList;

public class PrimeAndComposite {

    public int countFactors(int N) {  // todo - 92%
        int count = 0;

        // Iterate up to square root of n
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                // Increment count for factor i
                count++;

                // If i is not the square root of n, count n/i as well
                if (i * i != N) {
                    count++;
                }
            }
        }

        return count;
    }

    public int minPerimeterRectangle(int N) {
        int minPerimeter = Integer.MAX_VALUE;

        // Iterate over factors of N
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                int factor1 = i;
                int factor2 = N / i;

                // Calculate perimeter for the current pair of factors
                int perimeter = 2 * (factor1 + factor2);

                // Update minPerimeter if the current perimeter is smaller
                minPerimeter = Math.min(minPerimeter, perimeter);
            }
        }

        return minPerimeter;
    }

    public int maxFlags(int[] A) {
        int N = A.length;
        int[] peaks = new int[N];
        int peakCount = 0;

        // Find all the peaks in the array
        for (int i = 1; i < N - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks[peakCount++] = i;
            }
        }

        if (peakCount == 0) {
            // No peaks found, so no flags can be set
            return 0;
        }

        int result = 0;
        for (int flags = 1; flags <= peakCount; flags++) {
            int pos = 0;
            int count = 0;
            while (pos < peakCount && count < flags) {
                count++;
                int nextFlag = peaks[pos++] + flags;
                while (pos < peakCount && peaks[pos] < nextFlag) {
                    pos++;
                }
            }
            if (count >= flags) {
                result = flags;
            } else {
                break; // Not enough flags can be set
            }
        }

        return result;
    }

    public int maxFlags3(int[] A) {
        int N = A.length;
        if (N < 3)
            return 0;

        ArrayList<Integer> peaks = new ArrayList<Integer>();

        for (int i = 1; i < N - 1; i++) {

            if (A[i] > A[i - 1]) {
                if (A[i] > A[i + 1]) {
                    peaks.add(i);
                    i++;// skip for next as A[i + 1] <  A[i] so no need to check again

                }
            }
        }

        int size = peaks.size();
        if (size < 2)
            return size;

        int k = (int) Math.sqrt(peaks.get(size - 1) - peaks.get(0))+1; // added 1 to round off
        int flagsLeft = k - 1; // one flag is used for first element
        int maxFlag = 0;
        int prevEle = peaks.get(0);

        while (k > 0) { // will iterate in descending order
            flagsLeft = k - 1; // reset first peak flag
            prevEle = peaks.get(0);  // reset the flag to first element

            for (int i = 1; i < size && flagsLeft > 0; i++) {

                if (peaks.get(i) - prevEle >= k) {
                    flagsLeft--;
                    prevEle = peaks.get(i);
                }

                if ((size - 1 - i) < flagsLeft) { // as no. of peaks < flagsLeft
                    break;

                }
            }


            if (flagsLeft == 0 && maxFlag < k) {
                maxFlag = k;
                break; // will break at first highest flag as iterating in desc order
            }

            k--;
        }

        return maxFlag;
    }

    private int findNextPeak(int startPos, int[] prefixSums, int distance) {
        int endPos = startPos + distance;
        if (endPos >= prefixSums.length) {
            return prefixSums.length;
        }
        return prefixSums[endPos] - prefixSums[startPos] > 0 ? endPos : startPos;
    }

    private boolean[] createPeaks(int[] A) {
        boolean[] peaks = new boolean[A.length];
        for (int i = 1; i < A.length-1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                peaks[i] = true;
            }
        }

        return  peaks;
    }

    private int[] nextPeaks (int[] A) {
        boolean[] peaks = createPeaks(A);
        int[] nextPeaks = new int[A.length];
        // the last position is always -1
        nextPeaks[A.length-1] = -1;

        for (int i = A.length-2; i >= 0 ; i--) {
            nextPeaks[i] = peaks[i] ? i : nextPeaks[i+1];
        }

        return  nextPeaks;
    }



    public int maxBlocks2(int[] A) {
        // write your code in Java SE 8
        int[] peaks = new int[A.length];
        int peakStart = 0;
        int peakEnd = 0;

        //Find the peaks.
        //We don't want to traverse the array where peaks hasn't started, yet,
        //or where peaks doesn't occur any more.
        //Therefore, find start and end points of the peak as well.
        for(int i = 1; i < A.length-1; i++) {
            if(A[i-1] < A[i] && A[i+1] < A[i]) {
                peaks[i] = 1;
                peakEnd = i + 1;
            }
            if(peakStart == 0) {
                peakStart = i;
            }
        }

        int x = 1;
        //The maximum number of flags can be √N
        int limit = (int)Math.ceil(Math.sqrt(A.length));
        int prevPeak = 0;
        int counter = 0;
        int max = Integer.MIN_VALUE;

        while(x <= limit) {
            counter = 0;
            prevPeak = 0;
            for(int y = peakStart; y < peakEnd; y++) {
                //Find the peak points when we have x number of flags.
                if(peaks[y] == 1 && (prevPeak == 0 || x <= (y - prevPeak))) {
                    counter++;
                    prevPeak = y;
                }
                //If we don't have any more flags stop.
                if(counter == x ) {
                    break;
                }
            }
            //if the number of flags set on the peaks starts to reduce stop searching.
            if(counter <= max) {
                return max;
            }
            //Keep the maximum number of flags we set on.
            max = counter;
            x++;
        }
        return max;
    }

}
