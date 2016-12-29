/**
 *  Idea is refered from -> https://discuss.leetcode.com/topic/6148/my-really-simple-java-o-n-solution-accepted
 *  Time complexity -> O(n) (time complexity of map operations is O(logn))
 *  Idea: Using a map to store each number in nums, when there is a new number, do the following two things:
 *        1. If this number is already in the map, continue. If not, using (num-1) and (num+1) to get its neighbors' values,
 *           naming left and right. So the length of consecutive substring is (left+right+1).
 *        2. Use left and right to locate two border points of this consecutive substring, and update the new length to both
 *           border points. 
 */ 
public class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            if (map.containsKey(num)) continue;
            
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            
            int len = left + right + 1;
            res = Math.max(res, len);
            
            map.put(num, len);
            map.put(num - left, len);
            map.put(num + right, len);
        }
        
        return res;
    }
}
