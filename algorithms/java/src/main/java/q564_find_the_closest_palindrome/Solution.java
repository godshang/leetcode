package q564_find_the_closest_palindrome;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public String nearestPalindromic(String n) {
        int len = n.length();
        long num = Long.parseLong(n);
        boolean isEven = (len % 2) == 0;

        Set<Long> set = new HashSet<>();
        set.add((long) (Math.pow(10, (len - 1)) - 1));
        set.add((long) (Math.pow(10, len) + 1));

        String prefix = n.substring(0, (len + 1) / 2);
        long t = Long.parseLong(prefix);
        for (long i = t - 1; i <= t + 1; i++) {
            long tmp = getPalindromic(i, isEven);
            if (tmp != num) {
                set.add(tmp);
            }
        }

        long ans = -1;
        for (long l : set) {
            if (ans == -1
                    || (Math.abs(l - num) < Math.abs(ans - num))
                    || (Math.abs(l - num) == Math.abs(ans - num) && l < ans)) {
                ans = l;
            }
        }
        return String.valueOf(ans);
    }

    private long getPalindromic(long t, boolean isEven) {
        StringBuilder sb = new StringBuilder();
        sb.append(t);
        int idx = sb.length() + (isEven ? -1 : -2);
        while (idx >= 0) {
            sb.append(sb.charAt(idx--));
        }
        return Long.parseLong(sb.toString());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nearestPalindromic("123"));
        System.out.println(solution.nearestPalindromic("12345"));
        System.out.println(solution.nearestPalindromic("1"));
    }
}
