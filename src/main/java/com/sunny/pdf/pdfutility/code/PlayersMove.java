package com.sunny.pdf.pdfutility.code;

public class PlayersMove {
    public int solution(String S) {
        int N = S.length();
        boolean[] field = new boolean[N];
        int successfulMoves = 0;

        for (int i = 0; i < N; i++) {
            char move = S.charAt(i);
            int targetPosition = -1;

            // Determine the target position based on the move direction
            if (move == '<' && i > 0) {
                targetPosition = i - 1;
            } else if (move == '>' && i < N - 1) {
                targetPosition = i + 1;
            } else if (move == 'v') {
                targetPosition = i;
            } else if (move == '^') {
                targetPosition = i;
            }

            // Check if the target position is valid and not already occupied
            if (targetPosition >= 0 && targetPosition < N && !field[targetPosition]) {
                field[targetPosition] = true;
                successfulMoves++;
            }
        }

        return successfulMoves;
    }

    public static void main(String[] args) {
        PlayersMove pm = new PlayersMove();
        // Test cases
        System.out.println(pm.solution("<v>v<")); // Output: 4
        System.out.println(pm.solution(">>>>"));  // Output: 3
        System.out.println(pm.solution("v<v>"));  // Output: 3
        System.out.println(pm.solution("<<<v"));  // Output: 3
        System.out.println(pm.solution("^^^"));   // Output: 3
        System.out.println(pm.solution("<>^v"));  // Output: 4

        System.out.println(pm.solution("><^v"));  // Output: 2
        System.out.println(pm.solution("<<^<v>>"));  // Output: 6

    }
}

