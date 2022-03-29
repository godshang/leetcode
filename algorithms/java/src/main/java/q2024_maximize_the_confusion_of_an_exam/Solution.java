package q2024_maximize_the_confusion_of_an_exam;

public class Solution {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(getCnt(answerKey, 'F', k), getCnt(answerKey, 'T', k));
    }

    private int getCnt(String s, char c, int k) {
        int ans = 0, n = s.length();
        for (int i = 0, j = 0, cnt = 0; i < n; i++) {
            if (s.charAt(i) == c) cnt++;
            while (cnt > k) {
                if (s.charAt(j) == c) cnt--;
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxConsecutiveAnswers("TTFF", 2));
        System.out.println(solution.maxConsecutiveAnswers("TFFT", 1));
        System.out.println(solution.maxConsecutiveAnswers("TTFTTFTT", 1));
    }
}
