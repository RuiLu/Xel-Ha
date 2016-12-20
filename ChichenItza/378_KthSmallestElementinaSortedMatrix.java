public class Solution {
    /**
     *  Idea -> Maintain a MinHeap, elements in the MinHeap come from each column
     *  Time complexity -> O(klogn)
     *  Space complexity -> O(n), where n is the number of column
     */
    class Node {
        int val;
        int x;
        int y;
        
        public Node(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> a.val - b.val);
        
        for (int j = 0; j < n; j++) pq.offer(new Node(matrix[0][j], 0, j));
        
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (--k == 0) return node.val;
            if (node.x == m - 1) continue;  // reach the bottom line
            pq.offer(new Node(matrix[node.x+1][node.y], node.x + 1, node.y));
        }
        
        return 0;
    }
    
    /**
     *  Idea -> Binary search for range instead of index
     *  Time complexity -> O(nlogmn)
     */
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int lo = matrix[0][0];
        int hi = matrix[m-1][n-1];
        
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int count = 0;
            int j = n - 1;
            for (int i = 0; i < m; i++) {
                while (j >= 0 && matrix[i][j] > mid) j--;
                count += j + 1;
            }
            if (count < k) lo = mid + 1;
            else hi = mid;
        }
        
        return lo;
    }
}
