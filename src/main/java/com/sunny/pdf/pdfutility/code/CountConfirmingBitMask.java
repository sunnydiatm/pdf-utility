package com.sunny.pdf.pdfutility.code;

public class CountConfirmingBitMask {

    public int zeros(int n) {
        int res = 0;
        for (int i = 0; i < 30; i++) {
            if (n % 2 == 0) {
                res++;
            }
            n >>= 1;
        }
        return res;
    }

    public int confs(int n) {
        return 1 << zeros(n);
    }

    int solution(int A, int B, int C) {
        int common = confs(A | B) + confs(A | C) + confs(B | C) - confs(A | B | C);
        return confs(A) + confs(B) + confs(C) - common;
    }

    public static void main(String[] args) {
        CountConfirmingBitMask countConfirmingBitMask = new CountConfirmingBitMask();
        System.out.println(countConfirmingBitMask.solution(1073741727, 1073741727, 1073741679));
    }
}
