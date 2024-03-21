package com.sunny.pdf.pdfutility.code;

public class MakingCandies {

    public long minimumPasses(long m, long w, long p, long n) {
        long candy = 0L;
        long countDays = 0L;
        long production = 0L;
        long canBuy = 0L;
        if (n / m <= w) return 1;
        long daysRemaining = n % (m * w) == 0 ? n / (m * w) : (n / (m * w)) + 1;
        while (countDays <= daysRemaining) {
            if (Long.MAX_VALUE / m <= w) return countDays + 1;
            production = m * w;
            if (candy + production < p) {
                countDays = countDays + ((p - candy) / production) - 1;
                candy += (m * w) * ((p - candy) / production) - (m * w) ;
            }
            canBuy = (production + candy) / p;
            if (production + candy < n && canBuy > 0) {
                long v = Math.abs(m - w);
                if (canBuy > v) {
                    m = Math.max(m, w);
                    m = ((canBuy - v) % 2) == 1
                            ? m + ((canBuy - v) / 2) + 1
                            : m + ((canBuy - v) / 2);
                    w = ((canBuy - v) % 2) == 1
                            ? m - 1
                            : m;
                } else {
                    if (m > w) {
                        w += canBuy;
                    } else {
                        m += canBuy;
                    }
                }
                production -= canBuy * p;
            }
            candy += production;
            countDays++;
            daysRemaining = Math.min(daysRemaining,
                    countDays + (((n - candy) % (m * w)) == 0
                            ? ((n - candy) / (m * w))
                            : ((n - candy) / (m * w)) + 1L));
        }
        return Math.min(countDays, daysRemaining);

    }

}
