package q780_reaching_points;

public class Solution {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > sx && ty > sy) {
            if (tx < ty) ty %= tx;
            else tx %= ty;
        }
        if (tx < sx || ty < sy) return false;
        return sx == tx ? ((ty - sy) % tx == 0) : ((tx - sx) % ty == 0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reachingPoints(1, 1, 3, 5));
    }
}
