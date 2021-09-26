package q551_student_attendance_record_i;

public class Solution {

    public boolean checkRecord(String s) {
        int n = s.length();
        int absent = 0, late = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'A') {
                absent++;
                if (absent >= 2) return false;
            }
            if (s.charAt(i) == 'L') {
                late++;
                if (late >= 3) return false;
            } else {
                late = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkRecord("PPALLP"));
        System.out.println(solution.checkRecord("PPALLL"));
    }
}
