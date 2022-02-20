package q1791_find_center_of_star_graph;

public class Solution {

    public int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findCenter(new int[][]{{1, 2}, {2, 3}, {4, 2}}));
    }
}
