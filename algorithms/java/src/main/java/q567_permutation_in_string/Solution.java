package q567_permutation_in_string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : s1.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);
        
        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (Objects.equals(window.get(c), need.get(c))) {
                    valid++;
                }
            }
            
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                
                char d = s2.charAt(left);
                left++;
                
                if (need.containsKey(d)) {
                    if (Objects.equals(window.get(d), need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkInclusion("ab", "eidbaooo"));
        System.out.println(solution.checkInclusion("ab", "eidboaoo"));
    }
}
