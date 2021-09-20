package q389_find_the_difference;

import java.util.Arrays;

public class Solution {

    public char findTheDifference(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        int n = ch1.length < ch2.length ? ch1.length : ch2.length;
        for (int i = 0; i < n; i++) {
            if (ch1[i] != ch2[i]) {
                return ch1.length < ch2.length ? ch2[i] : ch1[i];
            }
        }
        return ch1.length < ch2.length ? ch2[ch2.length - 1] : ch1[ch1.length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTheDifference("abcd", "abcde"));
        System.out.println(solution.findTheDifference("", "y"));
        System.out.println(solution.findTheDifference("a", "aa"));
        System.out.println(solution.findTheDifference("ae", "aea"));
    }
}
