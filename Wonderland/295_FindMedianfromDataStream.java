/**
 *  Maintain a minHeap and a maxHeap
 *  Keep minHeap storing right part of numbers (bigger), keep maxHeap storing left part of numbers (smaller)
 *  So when doing minHeap.poll() and maxHeap.poll(), we will get the two numbers that are in the middle of the array
 */
class MedianFinder {
    
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Ascending order
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // Descending order
	
    // Adds a number into the data structure.
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll()); // get the maximum number from maxHeap
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll()); // maintain the size of maxHeap is greater or equal to the size of minHeap
        }
    }
    // Returns the median of current data stream
    public double findMedian() {
    	if (maxHeap.size() == minHeap.size()) return (maxHeap.peek() + minHeap.peek()) / 2.0;
    	else return maxHeap.peek() * 1.0;
    }
}

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();


