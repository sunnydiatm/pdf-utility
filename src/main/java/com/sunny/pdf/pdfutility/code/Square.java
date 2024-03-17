package com.sunny.pdf.pdfutility.code;

public class Square {

    public static int squares(int a, int b) {
        // Write your code here

        int count = 0 ;
        for (int i = a; i <=b ; i++) {
            double d = Math.sqrt(i);
            if (d % 1 == 0) {
                count++;
            }
        }

        return count;
    }

    public static int squaresEfficient(int a, int b) {
        // Write your code here

        return (int) (Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1);

    }


    public static void main(String[] args) {
        System.out.println(squares(16, 49));
    }
}
