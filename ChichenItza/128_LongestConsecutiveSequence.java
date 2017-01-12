public class Solution {
    /**
     *  Idea -> Maintain a HashMap.
     *          KEY is number in array, VALUE is its maximum length in its corresponding consecutive sequence.
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            if (map.containsKey(num)) continue;
            
            int len = 1;
            if (map.containsKey(num-1) && map.containsKey(num+1)) {
                int left = map.get(num-1);
                int right = map.get(num+1);
                len = left+right+1;
                map.put(num-left, len);
                map.put(num+right, len);
            } else if (map.containsKey(num-1)) {
                int left = map.get(num-1);
                len = left+1;
                map.put(num-left, len);
            } else if (map.containsKey(num+1)) {
                int right = map.get(num+1);
                len = right+1;
                map.put(num+right, len);
            }
            
            map.put(num, len);
            maxLen = Math.max(maxLen, len);
        }
        
        return maxLen;
    }
}
