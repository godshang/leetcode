package q748_shortest_completing_word;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : licensePlate.toCharArray()) {
            if (Character.isLetter(ch)) {
                ch = Character.toLowerCase(ch);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }

        String res = null;
        for (String word : words) {
            if (isCompletingWord(word, map)) {
                if (res == null || word.length() < res.length()) {
                    res = word;
                }
            }
        }
        return res;
    }

    private boolean isCompletingWord(String word, Map<Character, Integer> map) {
        Map<Character, Integer> count = new HashMap<>();
        for (char ch : word.toCharArray()) {
            if (map.containsKey(ch)) {
                count.put(ch, count.getOrDefault(ch, 0) + 1);
            }
        }
        if (count.isEmpty()) {
            return false;
        }
        for (Character ch : map.keySet()) {
            if (!count.containsKey(ch)) {
                return false;
            }
            if (count.get(ch) < map.get(ch)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.shortestCompletingWord("1s3 PSt",
                new String[]{"step", "steps", "stripe", "stepple"}));
        System.out.println(solution.shortestCompletingWord("1s3 456",
                new String[]{"looks", "pest", "stew", "show"}));
        System.out.println(solution.shortestCompletingWord("Ah71752",
                new String[]{"suggest", "letter", "of", "husband", "easy", "education", "drug", "prevent", "writer", "old"}));
        System.out.println(solution.shortestCompletingWord("OgEu755",
                new String[]{"enough", "these", "play", "wide", "wonder", "box", "arrive", "money", "tax", "thus"}));
        System.out.println(solution.shortestCompletingWord("iMSlpe4",
                new String[]{"claim", "consumer", "student", "camera", "public", "never", "wonder", "simple", "thought", "use"}));
    }
}
