package q929_unique_email_addresses;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            int pos = email.indexOf("@");
            String domain = email.substring(pos);
            String name = email.substring(0, pos);
            pos = name.indexOf("+");
            if (pos > 0) {
                name = name.substring(0, pos);
            }
            name = name.replaceAll("\\.", "");
            set.add(name + domain);
        }
        System.out.println(set);
        return set.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
        System.out.println(solution.numUniqueEmails(new String[]{"linqmafia@leet+code.com", "linqmafia@code.com"}));
    }
}
