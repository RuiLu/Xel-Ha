public class Solution {
    /**
     *  Idea -> Binary Search
     *  Time complexity -> O(logn)
     */
    public int findPeakElement(int[] nums) {
       if (nums == null || nums.length <= 1) return 0;
       
       int lo = 0;
       int hi = nums.length - 1;
       
       while (lo <= hi) {
           int mid = (lo + hi) / 2;
           
           if (mid == 0) {
               if (nums[mid] > nums[mid+1]) return mid;
               else return mid + 1;
           } else if (mid == nums.length - 1) {
               if (nums[mid] > nums[mid-1]) return mid;
               else return mid - 1;
           } else {
               if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
               else if (nums[mid] < nums[mid-1]) hi = mid - 1;
               else if (nums[mid] < nums[mid+1]) lo = mid + 1;
           }
       }
       
       return lo;
    } 
    
    /**
     *  Idea -> naive...
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] > nums[i+1]) return i;
            } else if (i == nums.length - 1) {
                if (nums[i] > nums[i-1]) return i;
            } else if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
                return i;
            }
        }
        
        return 0;
    }
}
