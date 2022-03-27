package q682_baseball_game;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int calPoints(String[] ops) {
        List<Integer> list = new ArrayList<>();
        for (String op : ops) {
            if (op.equals("+")) {
                list.add(list.get(list.size() - 2) + list.get(list.size() - 1));
            } else if (op.equals("C")) {
                list.remove(list.size() - 1);
            } else if (op.equals("D")) {
                list.add(2 * list.get(list.size() - 1));
            } else {
                list.add(Integer.valueOf(op));
            }
        }
        return list.stream().mapToInt(i -> i).sum();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calPoints(new String[]{"5", "2", "C", "D", "+"}));
    }
}
