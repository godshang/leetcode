package q537_complex_number_multiplication;

public class Solution {

    public String complexNumberMultiply(String num1, String num2) {
        String[] ss1 = num1.split("\\+|i");
        String[] ss2 = num2.split("\\+|i");
        int a = Integer.parseInt(ss1[0]), b = Integer.parseInt(ss1[1]);
        int c = Integer.parseInt(ss2[0]), d = Integer.parseInt(ss2[1]);
        int A = a * c  - b * d;
        int B = b * c + a * d;
        return A + "+" + B + "i";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.complexNumberMultiply("1+1i", "1+1i"));
    }
}
