package com.sunny.pdf.pdfutility.code;

import java.util.Stack;

public class StoneWall {

    public int solution(int[] H) {
        Stack<Integer> stack = new Stack<>();
        int blocksNeeded = 0;

        for (int height : H) {
            while (!stack.isEmpty() && stack.peek() > height) {
                stack.pop(); // Remove blocks until top block is lower or equal to current height
            }
            if (stack.isEmpty() || stack.peek() < height) {
                stack.push(height); // Add a new block if stack is empty or top block is lower
                blocksNeeded++; // Increment block count
            }
        }

        return blocksNeeded;
    }

    public static void main(String[] args) {
        StoneWall solution = new StoneWall();
        int[] H = {8, 8, 5, 7, 9, 8, 7, 4, 8};
        System.out.println(solution.solution(H)); // Output: 7
    }

}
