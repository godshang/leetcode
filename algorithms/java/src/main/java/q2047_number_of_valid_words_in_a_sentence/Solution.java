package q2047_number_of_valid_words_in_a_sentence;

public class Solution {

    public int countValidWords(String sentence) {
        int n = sentence.length();
        int l = 0, r = 0;
        int ans = 0;
        while (r < n) {
            while (l < n && sentence.charAt(l) == ' ') l++;
            if (l >= n) break;
            r = l + 1;
            while (r < n && sentence.charAt(r) != ' ') r++;
            String s = sentence.substring(l, r);
//            System.out.println(s);
            if (isValid(s)) ans++;
            l = r;
        }
        return ans;
    }

    private boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if ((chars[i] >= 'a' && chars[i] <= 'z') || chars[i] == '-' || chars[i] == '!' || chars[i] == '.' || chars[i] == ',') {
                if (chars[i] == '-') {
                    if (++cnt1 > 1) return false;
                    if (i == 0 || i == n - 1) return false;
                    if (chars[i - 1] < 'a' || chars[i - 1] > 'z' || chars[i + 1] < 'a' || chars[i + 1] > 'z')
                        return false;
                }
                if (chars[i] == '!' || chars[i] == '.' || chars[i] == ',') {
                    if (++cnt2 > 1) return false;
                    if (i != n - 1) return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.countValidWords("cat and  dog"));
//        System.out.println(solution.countValidWords("!this  1-s b8d!"));
//        System.out.println(solution.countValidWords("alice and  bob are playing stone-game10"));
//        System.out.println(solution.countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));
        System.out.println(solution.countValidWords("!g 3 !sy "));
    }
}
