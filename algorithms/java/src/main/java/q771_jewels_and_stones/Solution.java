package q771_jewels_and_stones;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (char ch : jewels.toCharArray()) {
            set.add(ch);
        }

        int res = 0;
        for (char ch : stones.toCharArray()) {
            if (set.contains(ch)) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(solution.numJewelsInStones("z", "ZZ"));
    }
}
