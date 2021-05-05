package q622_design_circular_queue;

public class MyCircularQueue {

    private int[] queue;
    private int capacity;
    private int size;
    private int head;

    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.capacity = k;
        this.size = 0;
        this.head = 0;
    }

    public boolean enQueue(int value) {
        if (size == capacity)
            return false;
        int tail = (head + size) % capacity;
        queue[tail] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (size == 0)
            return false;
        head = (head + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        if (size == 0) return -1;
        return queue[head];
    }

    public int Rear() {
        if (size == 0) return -1;
        int tail = (head + size - 1) % capacity;
        return queue[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
