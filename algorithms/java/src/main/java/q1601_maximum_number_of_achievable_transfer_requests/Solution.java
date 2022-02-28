package q1601_maximum_number_of_achievable_transfer_requests;

public class Solution {

    public int maximumRequests(int n, int[][] requests) {
        int[] cnts = new int[n];
        return dfs(requests, cnts, 0, 0);
    }

    private int dfs(int[][] requests, int[] cnts, int idx, int picked) {
        if (idx == requests.length) {
            for (int cnt : cnts) {
                if (cnt != 0) return 0;
            }
            return picked;
        }

        int ans = 0;
        cnts[requests[idx][0]]--;
        cnts[requests[idx][1]]++;
        ans = Math.max(ans, dfs(requests, cnts, idx + 1, picked + 1));
        cnts[requests[idx][0]]++;
        cnts[requests[idx][1]]--;

        ans = Math.max(ans, dfs(requests, cnts, idx + 1, picked));
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumRequests(5, new int[][]{{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}}));
        System.out.println(solution.maximumRequests(3, new int[][]{{0, 0}, {1, 2}, {2, 1}}));
        System.out.println(solution.maximumRequests(4, new int[][]{{0, 3}, {3, 1}, {1, 2}, {2, 0}}));
    }
}
