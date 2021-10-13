package q40_combination_sum_ii;

import common.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, candidates.length - 1, res, list);
        return res;
    }

    private void dfs(int[] candidates, int target, int begin, int end, List<List<Integer>> res, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin; i <= end; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > begin && candidates[i] == candidates[i - 1]) {
                break;
            }
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, end, res, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printList(solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
