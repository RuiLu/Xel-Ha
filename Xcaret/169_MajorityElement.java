public class Solution {
    /**
     *  Moore voting algorithm
     *  Find reference here -> http://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int majorityElement(int[] nums) {
       int num = 0;
       int count = 0;
       
       for (int i = 0; i < nums.length; i++) {
           if (nums[i] == num) {
               count++;
           } else if (count == 0) {
               num = nums[i];
               count++;
           } else {
               count--;
           }
       }
       
       return num;
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
