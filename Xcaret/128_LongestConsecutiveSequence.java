public class Solution {
    /**
     *  Idea: Using a map to store each number in nums, when there is a new number, do the following two things:
     *  1. If this number is already in the map, continue. If not, using (num-1) and (num+1) to get its neighbors' values,
     *     naming left and right. So the length of consecutive substring is (left+right+1).
     *  2. Use left and right to locate two border points of this consecutive substring, and update the new length to both
     *     border points. 
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int longest = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            if (map.containsKey(num)) continue;
            
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            
            int currLen = left + right + 1;
            map.put(num, currLen);
            map.put(num - left, currLen);
            map.put(num + right, currLen);
        }
        
        for (int value : map.values()) {
            longest = Math.max(longest, value);
        }
        
        return longest;
    }
}
