public class Solution {
    /**
     *  Idea -> Floyd's cycle finding algorithm (tortoise and hare) 
     *          Existing duplicate means that there is a circle
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        
        int runner = 0;
        int walker = 0;
        int finder = 0;
        
        while (true) {
            walker = nums[walker];
            runner = nums[nums[runner]];
            if (walker == runner) break;
        }
        
        while (true) {
            if (walker == finder) return walker;
            walker = nums[walker];
            finder = nums[finder];
        }
    } 

}
