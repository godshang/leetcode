package q273_integer_to_english_words;

public class Solution {

    static String[] dict1 = {
            "Zero",
            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    static String[] dict2 = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    static String[] dict3 = {
            "Billion", "Million", "Thousand", ""
    };

    // Integer.MAX_VALUE = 2,147,483,647
    public String numberToWords(int num) {
        if (num == 0) return dict1[0];
        StringBuilder sb = new StringBuilder();
        for (int i = (int) 1e9, j = 0; i >= 1; i /= 1000, j++) {
            if (num < i) continue;
            sb.append(num2str(num / i) + dict3[j] + " ");
            num %= i;
        }
        String ans = sb.toString();
        return ans.trim();
    }

    private String num2str(int x) {
        String str = "";
        if (x >= 100) {
            str += dict1[x / 100] + " Hundred ";
            x %= 100;
        }
        if (x >= 20) {
            str += dict2[x / 10] + " ";
            x %= 10;
        }
        if (x != 0) {
            str += dict1[x] + " ";
        }
        return str;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberToWords(123));
        System.out.println(solution.numberToWords(12345));
        System.out.println(solution.numberToWords(1234567));
    }
}
