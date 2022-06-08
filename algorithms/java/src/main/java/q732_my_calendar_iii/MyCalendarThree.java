package q732_my_calendar_iii;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarThree {

    private TreeMap<Integer, Integer> cnt;

    public MyCalendarThree() {
        cnt = new TreeMap<>();
    }

    public int book(int start, int end) {
        int ans = 0, maxBook = 0;
        cnt.put(start, cnt.getOrDefault(start, 0) + 1);
        cnt.put(end, cnt.getOrDefault(end, 0) - 1);
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int freg = entry.getValue();
            maxBook += freg;
            ans = Math.max(ans, maxBook);
        }
        return ans;
    }
}
