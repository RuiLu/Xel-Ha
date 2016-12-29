public class Solution {
    /**
     *  Using Bucket Sort
     *  Time complexity -> O(n)
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        
        if (nums == null || nums.length == 0) return res;
        
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            
            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }
        
        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null) res.addAll(bucket[i]);
        }
        
        return res;
    }    
    
    /**
     *  Using MaxHeap, so time complexity in worst case is O(nlogn)
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        
        if (nums == null || nums.length == 0) return res;
        
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> me : map.entrySet()) {
            pq.offer(me);
        }
        
        while (k-- > 0) {
            res.add(pq.poll().getKey());
        }
        
        return res;
    }
}
