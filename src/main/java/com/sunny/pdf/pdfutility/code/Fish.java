package com.sunny.pdf.pdfutility.code;

import java.util.Stack;

public class Fish {

    public int solution(int[] A, int[] B) {
        Stack<Integer> downstreamFish = new Stack<>();
        int survivedFish = 0;

        for (int i = 0; i < A.length; i++) {
            if (B[i] == 0) { // Upstream fish
                while (!downstreamFish.isEmpty() && A[i] > downstreamFish.peek()) {
                    downstreamFish.pop(); // Eat smaller downstream fish
                }
                if (downstreamFish.isEmpty()) {
                    survivedFish++; // Current fish survived
                }
            } else { // Downstream fish
                downstreamFish.push(A[i]);
            }
        }

        survivedFish += downstreamFish.size(); // Remaining downstream fish survived
        return survivedFish;
    }

    public static void main(String[] args) {
        Fish solution = new Fish();
        int[] A = {4, 3, 2, 1, 5};
        int[] B = {0, 1, 0, 0, 0};
        System.out.println(solution.solution(A, B)); // Output: 2
    }
}
