public class MedianFinder {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

    // Adds a number into the data structure.
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) maxHeap.offer(minHeap.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (minHeap.size() != maxHeap.size()) return maxHeap.peek() * 1.0;
        else return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
