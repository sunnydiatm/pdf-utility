package com.sunny.pdf.pdfutility.code;

import java.util.HashSet;
import java.util.Set;

public class Distinct {

    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            set.add(num);
        }
        return set.size();
    }

    public static void main(String[] args) {
        Distinct solution = new Distinct();
        int[] A = {2, 1, 1, 2, 3, 1};
        System.out.println(solution.solution(A)); // Output: 5
    }
}
