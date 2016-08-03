/*
 * Still using a minHeap (so common when facing kth smallest problems...)
 */
 
// 1. slower O(n) ? 
public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
        List<int[]> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;
        for (int i = 0; i < nums1.length && i < k; i++) {
            // the third element is used to indiciate the matching index in nums2 for every element in nums1
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            res.add(new int[]{curr[0], curr[1]});
            if (curr[2] == (nums2.length - 1)) continue;
            pq.offer(new int[]{curr[0], nums2[curr[2]+1], curr[2]+1});
        }
        return res;
    }
}


// 2. faster 0(mn) ?
public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k < 1) return res;
        
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                pq.offer(new Tuple(nums1[i], nums2[j]));
            }
        }
        
        while (!pq.isEmpty() && k > 0) {
            Tuple t = pq.poll();
            res.add(new int[]{t.first, t.second});
            k--;
        }
        
        return res;
    }
}

class Tuple implements Comparable<Tuple> {
    
    int first, second, val;
    
    public Tuple(int first, int second) {
        this.first = first;
        this.second = second;
        this.val = first + second;
    }
    
    @Override
    public int compareTo(Tuple that) {
        return this.val - that.val;
    }
    
}
