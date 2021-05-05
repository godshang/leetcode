package q38_count_and_say;

public class Solution {

    public String countAndSay(int n) {
        if (n == 1)
            return "1";

        String tmp = countAndSay(n - 1);

        StringBuilder sb = new StringBuilder();
        char c = tmp.charAt(0);
        int count = 0;
        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == c) {
                count++;
            } else {
                sb.append(count).append(c);
                c = tmp.charAt(i);
                count = 1;
            }
        }
        sb.append(count).append(c);

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i <= 5; i++) {
            System.out.println(solution.countAndSay(i));
        }
    }
}
