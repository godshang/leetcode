package q657_robot_return_to_origin;

public class Solution {

    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (int i = 0; i < moves.length(); i++) {
            char ch = moves.charAt(i);
            if (ch == 'L') x -= 1;
            else if (ch == 'R') x += 1;
            else if (ch == 'U') y += 1;
            else if (ch == 'D') y -= 1;
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.judgeCircle("UD"));
        System.out.println(solution.judgeCircle("LL"));
    }
}
