package q385_mini_parser;

public class Solution {

    int index = 0;

    public NestedInteger deserialize(String s) {
        if (s.charAt(index) == '[') {
            index++;
            NestedInteger res = new NestedInteger();
            while (s.charAt(index) != ']') {
                res.add(deserialize(s));
                if (s.charAt(index) == ',') {
                    index++;
                }
            }
            index++;
            return res;
        } else {
            boolean negative = false;
            if (s.charAt(index) == '-') {
                negative = true;
                index++;
            }
            int num = 0;
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                num = num * 10 + (s.charAt(index) - '0');
                index++;
            }
            if (negative) {
                num = -num;
            }
            return new NestedInteger(num);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.deserialize("324"));
        System.out.println(solution.deserialize("[123,[456,[789]]]"));
    }
}
