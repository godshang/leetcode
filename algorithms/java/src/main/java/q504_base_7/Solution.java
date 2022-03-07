package q504_base_7;

public class Solution {

    public String convertToBase7(int num) {
        boolean flag = false;
        if (num < 0) flag = true;
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(num % 7);
            num = num / 7;
        } while (num > 0);
        if (flag) sb.append("-");
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertToBase7(100));
        System.out.println(solution.convertToBase7(-7));
        System.out.println(solution.convertToBase7(0));
    }
}
