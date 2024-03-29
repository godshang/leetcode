package q39_combination_sum;

import common.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, candidates.length - 1, res, list);
        return res;
    }

    private void dfs(int[] candidates, int target, int begin, int end, List<List<Integer>> res, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin; i <= end; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, end, res, list);
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
