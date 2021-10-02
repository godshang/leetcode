package q806_number_of_lines_to_write_string;

import common.Util;

public class Solution {

    public int[] numberOfLines(int[] widths, String s) {
        int line = 1, lineWidth = 0;
        for (char ch : s.toCharArray()) {
            int width = widths[ch - 'a'];
            if (lineWidth + width > 100) {
                line++;
                lineWidth = 0;
            }
            lineWidth += width;
        }

        return new int[]{line, lineWidth};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printArray(solution.numberOfLines(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "abcdefghijklmnopqrstuvwxyz"));
        Util.printArray(solution.numberOfLines(new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "bbbcccdddaaa"));
    }
}
