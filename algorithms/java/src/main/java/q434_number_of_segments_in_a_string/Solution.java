package q434_number_of_segments_in_a_string;

public class Solution {

    public int countSegments(String s) {
        if (s == null) return 0;
        s = s.trim();
        if (s.length() == 0) return 0;
        return s.split("\\s+").length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSegments("Hello, my name is John"));
    }
}
