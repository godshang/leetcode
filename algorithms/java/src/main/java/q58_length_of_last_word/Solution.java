package q58_length_of_last_word;

public class Solution {

    public int lengthOfLastWord(String s) {
        int len = 0, tail = s.length() - 1;
        while (tail >= 0 && s.charAt(tail) == ' ') tail--;
        while (tail >= 0 && s.charAt(tail) != ' ') {
            len++;
            tail--;
        }
        return len;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("Hello World"));
        System.out.println(solution.lengthOfLastWord("Fuck"));
        System.out.println(solution.lengthOfLastWord("Tom read a lot of book"));
        System.out.println(solution.lengthOfLastWord("a "));
        System.out.println(solution.lengthOfLastWord("       "));
    }
}
