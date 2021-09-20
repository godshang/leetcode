package q171_excel_sheet_column_number;

import java.math.BigDecimal;

public class Solution {
    
    private int power(int x) {
        int sum = 1;
        while (x-- > 0) {
            sum = sum * 26;
        }
        return sum;
    }
    
    public int fuck(String s) {
        int sum = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            sum += (c - 64) * power(len - i -1);
        }
        return sum;
    }

    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 +  (s.charAt(i) - 'A') + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.fuck("A"));
//        System.out.println(solution.fuck("AB"));
        System.out.println(solution.titleToNumber("FXSHRXW"));
        System.out.println(solution.fuck("FXSHRXW"));
        
//        System.out.println(solution.power(6));
//        System.out.println(new BigDecimal(Math.pow(26, 6)));
    }
}
