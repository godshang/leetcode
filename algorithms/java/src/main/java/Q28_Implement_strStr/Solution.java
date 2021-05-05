package q28_implement_strstr;

public class Solution {

    public int strStr(String haystack, String needle) {

        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length())
                    return i;
                if (i + j == haystack.length())
                    return -1;
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("hello", "ll"));
        System.out.println(solution.strStr("aaaaa", "bba"));
        System.out.println(solution.strStr("aaaaa", "aba"));
        System.out.println(solution.strStr("", ""));
        System.out.println(solution.strStr("mississippi", "mississippi"));
    }
}
