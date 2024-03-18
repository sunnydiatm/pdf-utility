package com.sunny.pdf.pdfutility.code;

public class FrogJump {

    public static int solution(int X, int Y, int D) {
        int distance = Y - X;
        int jumps = distance / D;
        // If there is a remainder after division, we need one more jump
        if (distance % D != 0) {
            jumps++;
        }
        return jumps;
    }

    public static void main(String[] args) {
        int X = 10; // Current position of the frog
        int Y = 85; // Target position
        int D = 30; // Fixed jump distance
        int minimalJumps = solution(X, Y, D);
        System.out.println("Minimal number of jumps: " + minimalJumps); // Output: 3
    }
}

