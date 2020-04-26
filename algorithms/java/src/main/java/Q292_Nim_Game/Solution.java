package Q292_Nim_Game;

public class Solution {

    public boolean canWinNim(int n) {
        return (n % 4) != 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i < 10; i++) {
            System.out.println(i + ":" + solution.canWinNim(i));
        }
    }
}
