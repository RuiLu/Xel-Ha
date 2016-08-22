public class MovingAverage {
    
    private int capacity;
    private int count = 0;
    private int sum = 0;
    private LinkedList<Integer> queue = new LinkedList<>();

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.capacity = size;
    }
    
    public double next(int val) {
        queue.offer(val);
        count++;
        sum += val;
        
        if (queue.size() > capacity) {
            sum -= queue.poll();
            count--;
        }
        
        return sum * 1.0 / count;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
