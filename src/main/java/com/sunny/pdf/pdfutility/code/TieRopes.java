package com.sunny.pdf.pdfutility.code;

public class TieRopes {

    public int solution(int k, int[] a) {
        // with greedy approach we just tie ropes until the length exceeds K, then tie new set of ropes
        // suppose that it's not the optimal way, so the last tied rope should be in another set
        // if it's length is >= k, then moving it from the set gives the same number of sets with length >= k, since the set's length is less than k.
        // if it's length is < k, then moving it from the set gives less number of sets with length >= k by 1. untied rope should use at least another one to make set with length >= k, which decreases number of ropes left, hence the result as well.
        int result = 0;
        int l = 0;
        for (final int value : a) {
            l += value;
            if (l >= k) {
                l = 0;
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TieRopes tieRopes = new TieRopes();
        int[] arr1 = {1,2,3,4,1,1,3};
        System.out.println(tieRopes.solution(4, arr1));
    }
}
