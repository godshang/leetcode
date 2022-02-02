package q2000_reverse_prefix_of_word;

public class Solution {

    public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        if (idx > 0) {
            StringBuilder sb = new StringBuilder(word.substring(0, idx + 1));
            return sb.reverse().append(word.substring(idx + 1)).toString();
        }
        return word;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reversePrefix("abcdefd", 'd'));
    }
}
