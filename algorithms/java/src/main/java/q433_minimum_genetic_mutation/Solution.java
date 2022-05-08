package q433_minimum_genetic_mutation;

import java.util.*;

public class Solution {

    static char[] keys = {'A', 'C', 'G', 'T'};

    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;

        Set<String> banks = new HashSet<>();
        Arrays.stream(bank).forEach(b -> banks.add(b));
        if (!banks.contains(end)) return -1;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        visited.add(start);

        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (keys[k] != cur.charAt(j)) {
                            StringBuffer sb = new StringBuffer(cur);
                            sb.setCharAt(j, keys[k]);
                            String next = sb.toString();
                            if (!visited.contains(next) && banks.contains(next)) {
                                if (next.equals(end)) {
                                    return step;
                                }
                                visited.add(next);
                                queue.offer(next);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
        System.out.println(solution.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
        System.out.println(solution.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC","AAACCCCC","AACCCCCC"}));
    }
}
