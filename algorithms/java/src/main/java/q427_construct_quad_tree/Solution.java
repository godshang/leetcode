package q427_construct_quad_tree;

public class Solution {

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        int n = grid.length;
        return recursive(grid, 0, 0, n, n);
    }

    private Node recursive(int[][] grid, int r0, int c0, int r1, int c1) {
        int p = grid[r0][c0];
        boolean same = true;
        for (int i = r0; i < r1; i++) {
            for (int j = c0; j < c1; j++) {
                if (grid[i][j] != p) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }

        if (same) {
            return new Node(p == 1, true);
        }

        return new Node(p == 1,
                false,
                recursive(grid, r0, c0, (r0 + r1) / 2, (c0 + c1) / 2),
                recursive(grid, r0, (c0 + c1) / 2, (r0 + r1) / 2, c1),
                recursive(grid, (r0 + r1) / 2, c0, r1, (c0 + c1) / 2),
                recursive(grid, (r0 + r1) / 2, (c0 + c1) / 2, r1, c1));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.construct(new int[][]{
                {0, 1},
                {1, 0}
        }));
//        System.out.println(solution.construct(new int[][]{
//                {1, 1, 1, 1, 0, 0, 0, 0},
//                {1, 1, 1, 1, 0, 0, 0, 0},
//                {1, 1, 1, 1, 1, 1, 1, 1},
//                {1, 1, 1, 1, 1, 1, 1, 1},
//                {1, 1, 1, 1, 0, 0, 0, 0},
//                {1, 1, 1, 1, 0, 0, 0, 0},
//                {1, 1, 1, 1, 0, 0, 0, 0},
//                {1, 1, 1, 1, 0, 0, 0, 0}
//        }));
    }
}
