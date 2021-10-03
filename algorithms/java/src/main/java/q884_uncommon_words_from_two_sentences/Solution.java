package q884_uncommon_words_from_two_sentences;

import common.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        String[] array1 = s1.split("\\s"), array2 = s2.split("\\s");
        for (String word : array1) {
            map1.put(word, map1.getOrDefault(word, 0) + 1);
        }
        for (String word : array2) {
            map2.put(word, map2.getOrDefault(word, 0) + 1);
        }

        List<String> res = new ArrayList<>();
        for (String word : array1) {
            if (!map2.containsKey(word) && map1.get(word) == 1) {
                res.add(word);
            }
        }
        for (String word : array2) {
            if (!map1.containsKey(word) && map2.get(word) == 1) {
                res.add(word);
            }
        }
        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printArray(solution.uncommonFromSentences("this apple is sweet", "this apple is sour"));
        Util.printArray(solution.uncommonFromSentences("apple apple", "banana"));
    }
}
