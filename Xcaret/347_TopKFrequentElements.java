public class Solution {
    /**
     *  Idea -> Bucket sort
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        
        Map<Integer, Integer> freqMap = new HashMap<>();
        LinkedList<Integer>[] lists = new LinkedList[nums.length+1];
        
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (lists[freq] == null) lists[freq] = new LinkedList<>();
            lists[freq].add(key);
        }
        
        for (int i = lists.length - 1; i >= 0 && k > 0; i--) {
            if (lists[i] == null) continue;
            LinkedList<Integer> list = lists[i];
            for (int j = 0; j < list.size() && k > 0; j++) {
                res.add(list.get(j));
                k--;
            }
        }
        
        return res;
    }
}
