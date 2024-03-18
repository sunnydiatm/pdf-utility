package com.sunny.pdf.pdfutility.code;

public class TimeInWords {

    private static final String[] hours = {
            "", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve"
    };

    private static final String[] minutes = {
            "", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve", "thirteen",
            "fourteen", "quarter", "sixteen", "seventeen", "eighteen",
            "nineteen", "twenty", "twenty one", "twenty two", "twenty three",
            "twenty four", "twenty five", "twenty six", "twenty seven",
            "twenty eight", "twenty nine", "half"
    };

    public static String timeInWords(int h, int m) {
        if (m == 0) {
            return hours[h] + " o' clock";
        } else if (m <= 30) {
            if (m == 1) {
                return "one minute past " + hours[h];
            } else if (m == 15) {
                return "quarter past " + hours[h];
            } else if (m == 30) {
                return "half past " + hours[h];
            } else if (m <= 20) {
                return minutes[m] + " minutes past " + hours[h];
            } else {
                return minutes[20] + " " + minutes[m - 20] + " minutes past " + hours[h];
            }
        } else {
            m = 60 - m;
            h = (h == 12) ? 1 : h + 1;
            if (m == 1) {
                return "one minute to " + hours[h];
            } else if (m == 15) {
                return "quarter to " + hours[h];
            } else if (m <= 20) {
                return minutes[m] + " minutes to " + hours[h];
            } else {
                return minutes[20] + " " + minutes[m - 20] + " minutes to " + hours[h];
            }
        }
    }

    public static void main(String[] args) {
        int h = 5; // Hour
        int m = 47; // Minute
        System.out.println(timeInWords(h, m)); // Output: thirteen minutes to six
    }
}

