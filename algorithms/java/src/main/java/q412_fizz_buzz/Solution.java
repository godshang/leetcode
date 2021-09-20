package q412_fizz_buzz;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean b3 = i % 3 == 0;
            boolean b5 = i % 5 == 0;
            
            if (b3 && b5) {
                res.add("FizzBuzz");
            } else if (b3) {
                res.add("Fizz");
            } else if (b5) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fizzBuzz(15));
    }
}
