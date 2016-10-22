public class Solution {
    /**
     *  Idea -> There are at most two majority elements
     *          Voting!!
     *          First round to get two candidates
     *          Second round to choose from these two candidates, finding who is/are meeting requirement
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return list;
        
        int num1 = 0;
        int num2 = 0;
        int count1 = 0;
        int count2 = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) {
                count1++;
            } else if (nums[i] == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                num2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        
        for (int num : nums) {
            if (num == num1) count1++;
            else if (num == num2) count2++;
        }
        
        if (count1 > nums.length / 3) list.add(num1);
        if (count2 > nums.length / 3) list.add(num2);
       
        return list;
    }
}
