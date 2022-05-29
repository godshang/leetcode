package q468_validate_ip_address;

public class Solution {

    public String validIPAddress(String queryIP) {
        if (isIPv4(queryIP))
            return "IPv4";
        if (isIPv6(queryIP))
            return "IPv6";
        return "Neither";
    }

    private boolean isIPv4(String ip) {
        if (!ip.contains(".")) return false;
        String[] arr = ip.split("\\.", -1);
        if (arr.length != 4) return false;
        for (String s : arr) {
            Integer i = atoi(s);
            if (i == null || i < 0 || i > 255) return false;
            if (!s.equals(i.toString())) return false;
        }
        return true;
    }

    private boolean isIPv6(String ip) {
        if (!ip.contains(":")) return false;
        String[] arr = ip.split(":", -1);
        if (arr.length != 8) return false;
        for (String s : arr) {
            if (s.length() < 1 || s.length() > 4) return false;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) return false;
            }
        }
        return true;
    }

    private Integer atoi(String s) {
        try {
            return Integer.valueOf(s);
        } catch (Exception e) {
            return null;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.validIPAddress("172.16.254.1"));
//        System.out.println(solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
//        System.out.println(solution.validIPAddress("256.256.256.256"));
//        System.out.println(solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        System.out.println(solution.validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334"));
    }
}
