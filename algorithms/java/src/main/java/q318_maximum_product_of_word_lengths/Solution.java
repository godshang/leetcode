package q318_maximum_product_of_word_lengths;

public class Solution {

    public int maxProduct(String[] words) {
        int n = words.length, idx = 0;
        int[] masks = new int[n];
        for (String word : words) {
            int mask = 0;
            for (int i = 0; i < word.length(); i++) {
                int u = word.charAt(i) - 'a';
                mask = mask | (1 << u);
            }
            masks[idx++] = mask;
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
        System.out.println(solution.maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"}));
        System.out.println(solution.maxProduct(new String[]{"a","aa","aaa","aaaa"}));
    }
}
