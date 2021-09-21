package q520_detect_capital;

public class Solution {

    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) return true;
        boolean base = Character.isUpperCase(word.charAt(1));
        for (int i = 2; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i)) != base) return false;
        }
        return base ? Character.isUpperCase(word.charAt(0)) : true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.detectCapitalUse("USA"));
        System.out.println(solution.detectCapitalUse("FlaG"));
    }
}
