public class HitCounter {
    /**
     *  Follow up -> What if the number of hits per second could be very large? Does your design scale?
     *  I can create a private class
     */
    class Hits {
        int timestamp;
        int count;
        
        public Hits(int timestamp) {
            this.timestamp = timestamp;
            count = 1;
        }
        
        public void increaseHit() {
            count++;
        }
    }
    
    private Deque<Hits> queue;
    private int hitNum = 0;

    /** Initialize your data structure here. */
    public HitCounter() {
        queue = new ArrayDeque<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (queue.isEmpty() || queue.getLast().timestamp != timestamp) {
            queue.offer(new Hits(timestamp));
        } else {
            queue.getLast().increaseHit();   
        }
        hitNum++;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && (timestamp - queue.peek().timestamp) >= 300) {
            hitNum -= queue.poll().count;
        }
        return hitNum;
    }
    
    /**
     *  Normal, using queue
     */
    // private Deque<Integer> queue;

    // /** Initialize your data structure here. */
    // public HitCounter() {
    //     queue = new ArrayDeque<>();
    // }
    
    // /** Record a hit.
    //     @param timestamp - The current timestamp (in seconds granularity). */
    // public void hit(int timestamp) {
    //     queue.offer(timestamp);
    // }
    
    // /** Return the number of hits in the past 5 minutes.
    //     @param timestamp - The current timestamp (in seconds granularity). */
    // public int getHits(int timestamp) {
    //     while (!queue.isEmpty() && (timestamp - queue.peek()) >= 300) queue.poll();
    //     return queue.size();
    // }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
