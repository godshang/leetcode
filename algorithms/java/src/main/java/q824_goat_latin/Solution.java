package q824_goat_latin;

public class Solution {

    public String toGoatLatin(String sentence) {
        StringBuilder sb = new StringBuilder();
        String[] array = sentence.split("\\s");
        for (int i = 1; i <= array.length; i++) {
            String word = array[i - 1];
            if (isVowel(word.charAt(0))) sb.append(word);
            else sb.append(shift(word));
            sb.append("ma");

            for (int j = 0; j < i; j++)
                sb.append("a");
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    private String shift(String word) {
        char[] chars = word.toCharArray();
        char first = word.charAt(0);
        int n = word.length();
        for (int i = 1; i < n; i++) {
            chars[i - 1] = chars[i];
        }
        chars[n - 1] = first;
        return new String(chars);
    }

    private boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            return true;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.toGoatLatin("I speak Goat Latin"));
        System.out.println(solution.toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }
}
