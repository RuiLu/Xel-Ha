public class Solution {
    /**
     *  Idea -> Bucket sort
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0 || k <= 0) return res;
        
        List<Integer>[] freqList = new List[nums.length+1];
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> me : freqMap.entrySet()) {
            if (freqList[me.getValue()] == null) freqList[me.getValue()] = new ArrayList<Integer>();
            freqList[me.getValue()].add(me.getKey());
        }
        
        for (int i = nums.length; i >= 0 && k > 0; i--) {
            if (freqList[i] == null) continue;
            for (int num : freqList[i]) {
                res.add(num);
                k--;
                if (k <= 0) break;
            }
        }
        
        return res;
    }
    
    /**
     *  Idea -> MaxHeap
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0 || k <= 0) return res;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = 
                            new PriorityQueue<Map.Entry<Integer, Integer>>((a, b) -> b.getValue() - a.getValue());
                            
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        for (Map.Entry<Integer, Integer> me : map.entrySet()) pq.offer(me);
        while (res.size() < k) res.add(pq.poll().getKey());
        
        return res;
    }
     
    /**
     *  Idea -> MinHeap
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0 || k <= 0) return res;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        TreeMap<Integer, LinkedList<Integer>> tmap = new TreeMap<Integer, LinkedList<Integer>>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (!tmap.containsKey(freq)) {
                tmap.put(freq, new LinkedList<Integer>());
            }
            tmap.get(freq).add(key);
        }
        
        while (res.size() < k) {
            Map.Entry<Integer, LinkedList<Integer>> me = tmap.pollLastEntry();
            res.addAll(me.getValue());
        }
        
        return res;
    }
}
