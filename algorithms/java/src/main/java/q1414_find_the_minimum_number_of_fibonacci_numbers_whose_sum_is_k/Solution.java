package q1414_find_the_minimum_number_of_fibonacci_numbers_whose_sum_is_k;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int findMinFibonacciNumbers(int k) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int a = 1, b = 1;
        while (a + b <= k) {
            int c = a + b;
            list.add(c);
            a = b;
            b = c;
        }
        int ans = 0;
        for (int i = list.size() - 1; i >= 0 && k > 0; i--) {
            int num = list.get(i);
            if (k >= num) {
                k -= num;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMinFibonacciNumbers(7));
        System.out.println(solution.findMinFibonacciNumbers(10));
        System.out.println(solution.findMinFibonacciNumbers(19));
    }
}
