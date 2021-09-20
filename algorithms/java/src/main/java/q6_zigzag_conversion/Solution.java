package q6_zigzag_conversion;

public class Solution {

    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 0)
            return "";
        if (numRows == 1)
            return s;

//        StringBuilder sb = new StringBuilder();
//        int size = 2 * numRows - 2;
//        for (int i = 0; i < numRows; i++) {
//            for (int j = i; j < s.length(); j += size) {
//                sb.append(s.charAt(j));
//                if (i != 0 && i != numRows - 1) {
//                    int temp = j + size - 2 * i;
//                    if (temp < s.length()) {
//                        sb.append(s.charAt(temp));
//                    }
//                }
//            }
//        }
//
//        return sb.toString();

        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        int period = 2 * numRows - 2;
        for (int i = 0; i < s.length(); i++) {
            int reminder = i % period;
            if (reminder > numRows - 1) {
                sbs[period - reminder].append(s.charAt(i));
            } else {
                sbs[reminder].append(s.charAt(i));
            }
        }

        String ret = "";
        for (StringBuilder sb : sbs) {
            ret += sb.toString();
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 4));
    }
}
