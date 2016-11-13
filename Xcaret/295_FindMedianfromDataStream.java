public class MedianFinder {
    /**
     *  Idea -> https://discuss.leetcode.com/topic/27521/short-simple-java-c-python-o-log-n-o-1
     *  Time complexity -> O(logn) for addNum()
     *                     O(1) for findMedian
     */
    private PriorityQueue<Integer> large = new PriorityQueue<>();
    private PriorityQueue<Integer> small = new PriorityQueue<>((a, b) -> b - a);
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        large.offer(num);
        small.offer(large.poll());
        if (large.size() < small.size()) {
            large.offer(small.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (large.size() > small.size()) return large.peek() * 1.0;
        else return (large.peek() + small.peek()) / 2.0;
    }
}

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
