package q205_isomorphic_strings;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1).charValue() != c2)
                    return false;
            } else {
                if (!map.containsValue(c2))
                    map.put(c1, c2);
                else
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isIsomorphic("ab", "aa"));
//        System.out.println(solution.isIsomorphic("egg", "add"));
//        System.out.println(solution.isIsomorphic("foo", "bar"));
//        System.out.println(solution.isIsomorphic("paper", "title"));

    }
}
