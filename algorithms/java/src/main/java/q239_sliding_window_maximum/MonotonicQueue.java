package q239_sliding_window_maximum;

import java.util.LinkedList;

public class MonotonicQueue {

    private LinkedList<Integer> queue = new LinkedList<>();
    
    public void push(int num) {
        while (!queue.isEmpty() && queue.getLast() < num) {
            queue.removeLast();
        }
        queue.addLast(num);
    }
    
    public int max() {
        return queue.getFirst();
    }
    
    public void pop(int num) {
        if (num == queue.getFirst()) {
            queue.removeFirst();
        }
    }
}
