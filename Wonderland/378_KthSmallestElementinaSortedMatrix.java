/*
 * Using PriorityQueue to implement minHeap
 * 1. Build a minHeap using the elements in the first row
 * 2. Every time polling out an element(root of minHeap), offer the element in the next row but in the same column 
 *    to the PriorityQueue. Do this for k-1 times.
 */

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int len = matrix[0].length;
        
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        
        int bound = len < k ? len : k;
        for (int i = 0; i < bound; i++) pq.offer(new Tuple(0, i, matrix[0][i]));
        for (int i = 0; i < k - 1; i++) {
            Tuple t = pq.poll();
            if (t.row == (matrix.length - 1)) continue;
            pq.offer(new Tuple(t.row + 1, t.col, matrix[t.row + 1][t.col]));
        }
        
        return pq.poll().val;
    }
}

class Tuple implements Comparable<Tuple> {
    
    int row;
    int col;
    int val;
    
    public Tuple(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
    
    @Override
    public int compareTo(Tuple that) {
        return this.val - that.val;
    }
    
}
