package com.sunny.pdf.pdfutility.code;

public class ThreeLetters {

    public String threeLetters(int A, int B) {

    int limit = 3;
    StringBuilder temp = new StringBuilder();
    boolean forceA = false;
        while(A !=0||B !=0)

    {
        String lastCharacters = temp.length() > limit - 1
                ? temp.substring(temp.length() - limit + 1)
                : temp.toString();
        if (A >= B || forceA) {
            forceA = false;
            if (A != 0 && !lastCharacters.equals(new String(new char[limit - 1]).replace("\0", "a"))) {
                A = A - 1;
                temp.append('a');
                continue;
            }
        }
        if (B != 0 && !lastCharacters.equals(new String(new char[limit - 1]).replace("\0", "b"))) {
            B = B - 1;
            temp.append('b');
            continue;
        }
        forceA = true;
    }
        return temp.toString();
    }
}
