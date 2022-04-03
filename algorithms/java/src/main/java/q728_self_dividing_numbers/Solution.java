package q728_self_dividing_numbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isValid(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean isValid(int num) {
        int a = num;
        while (a > 0) {
            int b = a % 10;
            if (b == 0 || num % b != 0) return false;
            a = a / 10;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.selfDividingNumbers(1, 22));
        System.out.println(solution.selfDividingNumbers(47, 85));
    }
}
