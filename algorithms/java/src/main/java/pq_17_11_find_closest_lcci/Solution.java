package pq_17_11_find_closest_lcci;

public class Solution {

    public int findClosest(String[] words, String word1, String word2) {
        int n = words.length, ans = n;
        for (int i = 0, p = -1, q = -1; i < n; i++) {
            String w = words[i];
            if (w.equals(word1)) p = i;
            if (w.equals(word2)) q = i;
            if (p != -1 && q != -1) ans = Math.min(ans, Math.abs(p - q));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(solution.findClosest(new String[]{"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"}, "a", "student"));
    }
}
