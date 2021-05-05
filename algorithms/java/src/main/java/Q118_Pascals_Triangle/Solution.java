package q118_pascals_triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) 
            return Collections.emptyList();
        List<List<Integer>> list = new ArrayList<List<Integer>>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> line = new ArrayList<Integer>(i + 1);
            for (int j = 0; j < i + 1; j++)
                line.add(null);
            line.set(0, 1);
            line.set(line.size() - 1, 1);

            if (i >= 2) {
                List<Integer> prevLine = list.get(i - 1);
                for (int j = 1; j < i; j++)
                    line.set(j, prevLine.get(j - 1) + prevLine.get(j));
            }
            list.add(line);
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generate(5));
    }
}
