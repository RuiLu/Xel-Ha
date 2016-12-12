public class Solution {
    /**
     *  Idea -> Bucket sort, each bucket indicates a freqency.
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        if (nums == null || nums.length == 0 || nums.length < k || k < 0) return res;
        
        /* The length of buckets should be nums.length + 1 */
        List<Integer>[] buckets = new List[nums.length+1];
        HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        
        for (int num : nums) {
        	freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        for (int key : freqMap.keySet()) {
        	int value = freqMap.get(key);
        	if (buckets[value] == null) buckets[value] = new LinkedList<Integer>();
        	buckets[value].add(key);
        }
        
        for (int i = buckets.length - 1; i >= 0 && k > 0; i--) {
        	if (buckets[i] == null) continue;
        	for (int j = 0; j < buckets[i].size(); j++) {
        		res.add(buckets[i].get(j));
        		k--;
        		if (k == 0) break;
        	}
        }
        
        return res;
    }
    
    /**
     *  Idea -> MaxHeap
     *  Time complexity -> O(nlogn)
     */ 
    public List<Integer> topKFrequent(int[] nums, int k) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        if (nums == null || nums.length == 0 || nums.length < k || k < 0) return res;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = 
            new PriorityQueue<Map.Entry<Integer, Integer>>((a, b) -> b.getValue() - a.getValue());
        
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        for (Map.Entry<Integer, Integer> me : map.entrySet()) pq.offer(me);
        
        while (k-- > 0) res.add(pq.poll().getKey());
        
        return res;
    }
}
