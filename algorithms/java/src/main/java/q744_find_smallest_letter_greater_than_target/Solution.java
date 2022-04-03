package q744_find_smallest_letter_greater_than_target;

public class Solution {

    public char nextGreatestLetter(char[] letters, char target) {
        char ans = letters[0];
        for (char letter : letters) {
            if (letter > target) {
                ans = letter;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'a'));
        System.out.println(solution.nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'c'));
        System.out.println(solution.nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'd'));
    }
}
