public class MovingAverage {

    private Queue<Integer> queue;
    private int count;
    private int size;
    private double sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        sum = 0;
        count = 0;
        this.size = size;
    }
    
    public double next(int val) {
        count++;
        sum += val;
        queue.offer(val);
        if (count > size) {
            count--;
            sum -= queue.poll();
        }
        return sum / count;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
