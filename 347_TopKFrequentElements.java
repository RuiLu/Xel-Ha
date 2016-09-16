public class Solution {
    /**
     *  Using Bucket Sort
     *  Time complexity -> O(n)
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
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
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
        /* time complexity -> O(klogk), where k is the size of map */
        for (Map.Entry<Integer, Integer> me : map.entrySet()) {
            maxHeap.offer(me);
        }
        
        while (k-- > 0) res.add(maxHeap.poll().getKey());
        
        return res;
    }
}
