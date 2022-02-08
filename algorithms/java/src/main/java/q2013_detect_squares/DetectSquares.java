package q2013_detect_squares;

import java.util.HashMap;
import java.util.Map;

public class DetectSquares {

    private Map<Integer, Map<Integer, Integer>> rowToCol;

    public DetectSquares() {
        rowToCol = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0], y = point[1];
        Map<Integer, Integer> colToCnt = rowToCol.getOrDefault(x, new HashMap<>());
        colToCnt.put(y, colToCnt.getOrDefault(y, 0) + 1);
        rowToCol.put(x, colToCnt);
    }

    public int count(int[] point) {
        int x = point[0], y = point[1];
        int ans = 0;
        Map<Integer, Integer> colToCnt = rowToCol.getOrDefault(x, new HashMap<>());
        for (int ny : colToCnt.keySet()) {
            if (ny == y) continue;
            int c1 = colToCnt.get(ny);
            int len = y - ny;
            int[] nxes = new int[]{x + len, x - len};
            for (int nx : nxes) {
                Map<Integer, Integer> map = rowToCol.getOrDefault(nx, new HashMap<>());
                int c2 = map.getOrDefault(y, 0);
                int c3 = map.getOrDefault(ny, 0);
                ans += c1 * c2 *c3;
            }
        }
        return ans;
    }
}
