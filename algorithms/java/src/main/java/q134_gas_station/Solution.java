package q134_gas_station;

public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length) return -1;
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int totalGas = gas[i];
            int start = i, cur = start, next = cur + 1;
            while (true) {
                if (cur != i && cur % n == i) {
                    return i;
                }
                if (totalGas < cost[cur % n]) {
                    break;
                } else {
                    totalGas = totalGas - cost[cur % n];
                    totalGas += gas[next % n];
                    cur = next;
                    next += 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(solution.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }
}
