package com.sunny.pdf.pdfutility.code;

    public class PalindromeSolution {
        public String solution(String S) {
            int n = S.length();
            char[] chars = S.toCharArray();

            int i = 0, j = n - 1;
            while (i <= j) {
                if (chars[i] == '?' && chars[j] == '?') {
                    // Replace both with 'a' or any same character to make it minimal lexicographically
                    chars[i] = chars[j] = 'a';
                } else if (chars[i] == '?') {
                    // Replace ? at i with char at j
                    chars[i] = chars[j];
                } else if (chars[j] == '?') {
                    // Replace ? at j with char at i
                    chars[j] = chars[i];
                } else if (chars[i] != chars[j]) {
                    // If both chars are different and not ?, it's impossible to make a palindrome
                    return "NO";
                }
                i++;
                j--;
            }

            return new String(chars);
        }

        public static void main(String[] args) {
            PalindromeSolution ps = new PalindromeSolution();
            // Test cases
            System.out.println(ps.solution("ab?ba"));  // Output: "ababa"
            System.out.println(ps.solution("a??a"));  // Output: "aaaa"
            System.out.println(ps.solution("a?b"));   // Output: "NO"
            System.out.println(ps.solution("????"));  // Output: "aaaa"

            System.out.println(ps.solution("?ab??a"));  // Output: "aabbaa"
            System.out.println(ps.solution("bab??a"));  // Output: "NO"
            System.out.println(ps.solution("?a?"));  // Output: "aaa"
        }

}
