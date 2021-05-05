package q721_accounts_merge;

import java.util.*;

public class Solution {

    private Map<String, String> parents = new HashMap<>();
    private Map<String, String> emailToName = new HashMap<>();
    private Map<String, Set<String>> relatedMail = new HashMap<>();
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null || accounts.size() == 0) return Collections.emptyList();

        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String mail = account.get(i);
                parents.put(mail, mail);
                emailToName.put(mail, name);
            }
        }
        
        for (List<String> account : accounts) {
            String mail = account.get(1);
            for (int i = 2; i < account.size(); i++) {
                union(mail, account.get(i));
            }
        }
        
        for (List<String> account : accounts) {
            String root = find(account.get(1));
            for (int i = 1; i < account.size(); i++) {
                Set<String> set = relatedMail.getOrDefault(root, new TreeSet<>());
                set.add(account.get(i));
                relatedMail.put(root, set);
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        for (String root : relatedMail.keySet()) {
            List<String> account = new ArrayList<>();
            account.add(emailToName.get(root));
            account.addAll(relatedMail.get(root));
            res.add(account);
        }
        
        return res;
    }

    private String find(String s) {
        while (!parents.get(s).equals(s)) {
            parents.put(s, parents.get(parents.get(s)));
            s = parents.get(s);
        }
        return s;
    }

    private void union(String x, String y) {
        String px = find(x);
        String py = find(y);
        if (px.compareTo(py) > 0) {
            parents.put(px, py);
        } else {
            parents.put(py, px);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        List<List<String>> accounts = new ArrayList<>();
//        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
//        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));
//        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
//        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
//        System.out.println(solution.accountsMerge(accounts));

        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("David","David0@m.co","David4@m.co","David3@m.co"));
        accounts.add(Arrays.asList("David","David5@m.co","David5@m.co","David0@m.co"));
        accounts.add(Arrays.asList("David","David1@m.co","David4@m.co","David0@m.co"));
        accounts.add(Arrays.asList("David","David0@m.co","David1@m.co","David3@m.co"));
        accounts.add(Arrays.asList("David","David4@m.co","David1@m.co","David3@m.co"));
        System.out.println(solution.accountsMerge(accounts));
    }
}

