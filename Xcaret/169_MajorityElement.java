public class Solution {
    /**
     *  Moore voting algorithm
     *  Find reference here -> http://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int majorityElement(int[] nums) {
       int count = 0;
       int res = 0;
       for (int num : nums) {
           if (count == 0) res = num;
           if (res == num) count++;
           else count--;
       }
       return res;
    }
    
    /**
     *  Sorting
     *  Time complexity -> O(nlogn)
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    } 
}
