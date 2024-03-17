package com.sunny.pdf.pdfutility.code;

import java.util.List;

public class AngryProfessor {

    public static String angryProfessor(int k, List<Integer> list) {
        // Write your code here

        int alreadyPresentCount = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= 0) {
                alreadyPresentCount = alreadyPresentCount + 1;
            }
        }

        if (alreadyPresentCount >= k ) {
            return "NO";
        } else {
            return "YES";
        }

    }
}
