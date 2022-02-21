package q838_push_dominoes;

public class Solution {

    public String pushDominoes(String dominoes) {
        char[] s = dominoes.toCharArray();
        int n = dominoes.length();
        int i = 0;
        char left = 'L';
        while (i < n) {
            int j = i;
            while (j < n && s[j] == '.') {
                j++;
            }
            char right = j < n ? s[j] : 'R';
            if (left == right) {
                while (i < j) {
                    s[i++] = left;
                }
            } else if (left == 'R' && right == 'L') {
                int k = j - 1;
                while (i < k) {
                    s[i++] = 'R';
                    s[k--] = 'L';
                }
            }
            left = right;
            i = j + 1;
        }
        return new String(s);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pushDominoes("RR.L"));
        System.out.println(solution.pushDominoes(".L.R...LR..L.."));
    }
}
