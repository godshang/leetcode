package q482_license_key_formatting;

public class Solution {

    public String licenseKeyFormatting(String s, int k) {
        String str = s.replaceAll("-", "").toUpperCase();
        int n = str.length(), cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
            cnt++;
            if (cnt == k && i != 0) {
                sb.append("-");
                cnt = 0;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(solution.licenseKeyFormatting("2-5g-3-J", 2));
    }
}
