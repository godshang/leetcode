package q89_gray_code;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j));
            }
            head <<= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.grayCode(2));
    }
}
