package q393_utf_8_validation;

public class Solution {

    static int MASK1 = 1 << 7;
    static int MASK2 = (1 << 7) + (1 << 6);

    public boolean validUtf8(int[] data) {
        int len = data.length, index = 0;
        while (index < len) {
            int t = data[index];
            int n = getBytes(t);
            if (n < 0 || index + n > len) return false;
            for (int i = 1; i < n; i++) {
                if (!isValid(data[index + i])) return false;
            }
            index += n;
        }
        return true;
    }

    private int getBytes(int t) {
        if ((t & MASK1) == 0) return 1;
        int n = 0, mask = MASK1;
        while ((t & mask) != 0) {
            n++;
            if (n > 4) return -1;
            mask = mask >> 1;
        }
        return n >= 2 ? n : -1;
    }

    private boolean isValid(int t) {
        return (t & MASK2) == MASK1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validUtf8(new int[]{197, 130, 1}));
        System.out.println(solution.validUtf8(new int[]{235, 140, 4}));
    }
}
