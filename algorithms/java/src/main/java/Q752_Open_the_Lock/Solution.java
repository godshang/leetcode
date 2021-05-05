package q752_open_the_lock;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public int openLock(String[] deadends, String target) {

        Set<String> visited = new HashSet<>();
        for (String dead : deadends)
            visited.add(dead);

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int step = 0;
        
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String cur = queue.poll();
                
                if (visited.contains(cur))
                    continue;
                if (cur.equals(target))
                    return step;
                
                visited.add(cur);
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    queue.offer(up);
                    String down = minusOne(cur, j);
                    queue.offer(down);
                }
            }
            step++;
        }
        return -1;
    }

    private String plusOne(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '9')
            ch[i] = '0';
        else
            ch[i] += 1;
        return new String(ch);
    }

    private String minusOne(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '0')
            ch[i] = '9';
        else
            ch[i] -= 1;
        return new String(ch);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }
}
