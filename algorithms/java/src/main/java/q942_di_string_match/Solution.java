package q942_di_string_match;

import common.Util;

public class Solution {

    public int[] diStringMatch(String s) {
        int n = s.length(), low = 0, high = n;
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ans[i] = s.charAt(i) == 'I' ? low++ : high--;
        }
        ans[n] = low;
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();;
        Util.printArray(solution.diStringMatch("IDID"));
    }
}
