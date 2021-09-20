package q165_compare_version_numbers;

public class Solution {

    public int compareVersion(String version1, String version2) {
        String[] v1Array = version1.split("\\.");
        String[] v2Array = version2.split("\\.");
        int length = Math.max(v1Array.length, v2Array.length);
        int i = 0;
        while (i < length) {
            int i1 = i < v1Array.length ? Integer.parseInt(v1Array[i]) : 0;
            int i2 = i < v2Array.length ? Integer.parseInt(v2Array[i]) : 0;
            if (i1 < i2) {
                return -1;
            } else if (i1 > i2) {
                return 1;
            }
            i++;
        }
        return 0;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.compareVersion("1.01", "1.001"));
//        System.out.println(solution.compareVersion("1.0", "1.0.0"));
//        System.out.println(solution.compareVersion("0.1", "1.1"));
//        System.out.println(solution.compareVersion("1.0.1", "1"));
//        System.out.println(solution.compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(Integer.parseInt("001"));
    }
}

