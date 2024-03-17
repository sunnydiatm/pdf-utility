package com.sunny.pdf.pdfutility.code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignerPDFViewer {

    public static int designerPdfViewer(List<Integer> h, String word) {

        List<Character> listOfChars = List.of('a', 'b', 'c','d','e', 'f', 'g','h', 'i', 'j', 'k','l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < h.size(); i++) {
            map.put(listOfChars.get(i), h.get(i));
        }

        int tallest = 0;
        char[] wordInChar = word.toCharArray();
        for (int i = 0; i < word.trim().length(); i++) {
            int a = map.get(wordInChar[i]);
            if (a > tallest) {
                tallest = a;
            }
        }

        return word.trim().length() * tallest;
    }
}
