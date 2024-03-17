package com.sunny.pdf.pdfutility.code;

public class BeautifulDays {

    public static int beautifulDays(int i, int j, int k) {
        // Write your code here

        int count = 0;
        for (int l = i; l <= j; l++) {

            if (Math.abs(l - reverseInt(l)) % k == 0) {
                count = count + 1;
            }
        }
        return count;
    }

    public static int reverseInt(int x) {
        if (x == 0) {
            return x;
        }

        String str = String.valueOf(x);
        char[] arr = str.toCharArray();
        char[] temp = new char[str.length()];

        int j = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            temp[j] = arr[i];
            j++;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < temp.length; i++) {
            result.append(temp[i]);
        }

        return Integer.parseInt(result.toString());

    }

    public static void main(String[] args) {
        System.out.println(beautifulDays(20, 23, 6));
    }


}
