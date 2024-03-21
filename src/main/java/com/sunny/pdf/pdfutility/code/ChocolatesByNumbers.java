package com.sunny.pdf.pdfutility.code;

public class ChocolatesByNumbers {

    public int solution(int n, int m) {
        // we have to find less common multiple.
        // first time we meet a wrapper may happen only at the beginning of the circle.
        // it may happen after at least one circle is finished.
        // they meet at the 0th position the next time
        // it cannot be earlier since it's may be the only first time when the visited positions are repeated
        // so k*m = q*n in this case
        // the first time it happens when k * m is the less common multiple.
        // lcm(n, m) = n * m / gcm(n, m)
        // k = lcm(n, m) / m = n / gcm(n, m)
        return n / gcm(n, m);
    }

    private int gcm(final int n, final int m) {
        if (n % m == 0) {
            return m;
        } else {
            return gcm(m, n % m);
        }
    }

    public static void main(String[] args) {
        ChocolatesByNumbers chocolatesByNumbers = new ChocolatesByNumbers();
        System.out.println(chocolatesByNumbers.solution(10,4));
    }
}
