package com.sunny.pdf.pdfutility.code;

public class CountDiv {

    public int solution(int A, int B, int K) {
        int firstCount =0;
        int allCount =0;
        if (B==0)
            return 1;
        if (A>1){
            firstCount = (int)(A-1)/K;
        }
        allCount = (int)B/K;
        if (A==0)
            allCount++;
        return allCount-firstCount;
    }

    public static void main(String[] args) {
        CountDiv solution = new CountDiv();
        int A = 6, B = 11, K = 2; // Example values of A, B, and K
        int divisibleCount = solution.solution(A, B, K);
        System.out.println("Number of integers divisible by " + K + " in range [" + A + ".." + B + "]: " + divisibleCount); // Output: 3
    }
}
