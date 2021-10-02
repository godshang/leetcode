package q804_unique_morse_code_words;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int uniqueMorseRepresentations(String[] words) {
        String[] dict = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char ch : word.toCharArray()) {
                sb.append(dict[ch - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
