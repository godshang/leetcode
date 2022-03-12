package q2049_count_nodes_with_the_highest_score;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    long maxScore;
    int cnt;
    int n;
    List<Integer>[] children;

    public int countHighestScoreNodes(int[] parents) {
        this.n = parents.length;
        this.children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int p = parents[i];
            if (p != -1) {
                children[p].add(i);
            }
        }
        dfs(0);
        return cnt;
    }

    private int dfs(int node) {
        long score = 1;
        int size = n - 1;
        for (int c : children[node]) {
            int t = dfs(c);
            score *= t;
            size -= t;
        }
        if (node != 0) {
            score *= size;
        }
        if (score == maxScore) {
            cnt++;
        } else if (score > maxScore) {
            maxScore = score;
            cnt = 1;
        }
        return n - size;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countHighestScoreNodes(new int[]{-1, 2, 0, 2, 0}));
    }
}


