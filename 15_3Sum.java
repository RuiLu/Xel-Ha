public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> res = new ArrayList<>();
       if (nums == null || nums.length <= 2) return res;
       int len = nums.length;
       Arrays.sort(nums);   // O(nlogn)
       for (int i = 0; i < len - 2; i++) {  // O(n^2)
           if (i > 0 && nums[i] == nums[i - 1]) continue;   // prevent duplicates
           int left = i + 1;
           int right = len - 1;
           while (left < right) {
               int sum = nums[i] + nums[left] + nums[right];
               if (sum == 0) {
                   List<Integer> tmp = new ArrayList<>();
                   tmp.add(nums[i]);
                   tmp.add(nums[left]);
                   tmp.add(nums[right]);
                   res.add(tmp);
                   
                   left++;
                   right--;
                   // prevent duplicates
                   while (left < right && nums[left] == nums[left - 1]) left++;
                   while (left < right && nums[right] == nums[right + 1]) right--;
               } else if (sum > 0) {
                   right--;
               } else {
                   left++;
               }
           }
        }
        return res;
    }
}
