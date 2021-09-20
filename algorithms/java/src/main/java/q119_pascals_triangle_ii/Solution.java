package q119_pascals_triangle_ii;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>(rowIndex + 1);
        for (int i = 0; i < rowIndex + 1; i++)
            list.add(1);

        if (rowIndex >= 2) {
            for (int i = 2; i <= rowIndex; i++)
                for (int j = i - 1; j >= 1; j--)
                    list.set(j, list.get(j) + list.get(j - 1));
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getRow(3));
    }
}
