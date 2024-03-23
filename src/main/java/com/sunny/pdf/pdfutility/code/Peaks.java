package com.sunny.pdf.pdfutility.code;

import java.util.ArrayList;
import java.util.List;

public class Peaks {

    public static int peaks(int[] A) {
        // write your code in Java SE 8
        // main idea:
        // 1) find all the peaks, and put them into a List
        // 2) try to divide the array into a number of groups,
        //    and check if all the groups have at least one peak
        //--> if yes, return the "number of groups"

        // use "List" to store all the peaks
        List<Integer> peaksIndexList = new ArrayList<>();

        // 1) find the peaks (and store them)
        for(int i=1; i<A.length-1; i++){
            if( A[i-1]<A[i] && A[i]>A[i+1] ){ // A[i] > A[i-1], A[i] > A[i+1]
                peaksIndexList.add(i);
            }
        }

        // 2) check the number of Blocks
        int N = A.length;

        // from the "biggest possible number" to smaller number
        for(int numBlocks =N; numBlocks >=1; numBlocks--){

            if( N % numBlocks ==0){ // it is divisible

                int blockSize = N / numBlocks;
                int ithOkBlock =0;  // the ith block has peak(s)

                // test all the peaks
                // if a peak is found in the ith block
                // then, go to the (i+1)th block
                for(int peaksIndex : peaksIndexList){
                    if( peaksIndex/blockSize == ithOkBlock){ // peak in the ith block
                        ithOkBlock++; // go to check (i+1)th block
                    }
                }

                // ithOkBlock: the number of blocks having peak(s)
                // if all the blocks have peak(s)
                // then, return the number of blocks
                // note: we test from the biggest possible number
                // so, once we find it, we can just return it
                // (no need to check the smaller possible numbers)
                if(ithOkBlock == numBlocks){
                    return numBlocks;
                }
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        int[] a1 = { 1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 };
        System.out.println(peaks(a1));
    }
}
