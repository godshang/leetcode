package q944_delete_columns_to_make_sorted;

public class Solution {

    public int minDeletionSize(String[] strs) {
        int ans = 0, m = strs.length, n = strs[0].length();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDeletionSize(new String[]{"cba", "daf", "ghi"}));
        System.out.println(solution.minDeletionSize(new String[]{"a", "b"}));
        System.out.println(solution.minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
    }
}
