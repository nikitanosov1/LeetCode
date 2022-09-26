package problem_622;

class MyCircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int length;
    // front --- rear

    public MyCircularQueue(int k) {
        queue = new int[k];
        front = 0;
        rear = 0;
        capacity = k;
        length = 0;
    }

    public boolean enQueue(int value) {
        if (length == 0) {
            ++length;
            queue[rear] = value;
            return true;
        }
        if (isFull()) return false;
        rear = (rear + 1) % capacity;
        ++length;
        queue[rear] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        if (rear == front) {
            --length;
            return true;
        }
        front = (front + 1) % capacity; // !!
        --length;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return queue[front];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return queue[rear];
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public boolean isFull() {
        return (length == capacity);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */