package q39_combination_sum;

import common.Util;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(candidates, target, res, list, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        dfs(candidates, target, res, list, idx + 1);
        if (target - candidates[idx] >= 0) {
            list.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], res, list, idx);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printList(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
        Util.printList(solution.combinationSum(new int[]{2, 3, 5}, 8));
        Util.printList(solution.combinationSum(new int[]{2}, 1));
    }
}
