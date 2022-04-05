package q307_range_sum_query_mutable;

class NumArray {

    int[] nums;
    int n;
    int[] tree;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }

    public void update(int index, int val) {
        add(index + 1, val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }

    int lowbit(int x) {
        return x & -x;
    }

    void add(int x, int val) {
        for (int i = x; i < tree.length; i += lowbit(i)) {
            tree[i] += val;
        }
    }

    int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            ans += tree[i];
        }
        return ans;
    }
}

public class Solution {

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }
}
