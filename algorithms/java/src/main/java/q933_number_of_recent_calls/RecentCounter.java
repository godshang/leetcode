package q933_number_of_recent_calls;

import java.util.PriorityQueue;

public class RecentCounter {

    PriorityQueue<Integer> pq;

    public RecentCounter() {
        pq = new PriorityQueue<>();
    }

    public int ping(int t) {
        pq.add(t);
        while (t - 3000 > pq.peek()) {
            pq.poll();
        }
        return pq.size();
    }
}
