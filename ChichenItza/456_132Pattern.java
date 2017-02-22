public class Solution {
    /**
     * Time complexity -> O(n)
     * Space complexity -> O(n)
     */
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        
        /* maintain s3 */
        int s3 = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        
        /* the condition for s3 is that there exist the number whose value between nums[i] and s3 is bigger than s3 */
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] < s3) return true;
            else {
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    s3 = stack.peek();
                    stack.pop();
                }
                stack.push(nums[i]);
            }
        }
        
        return false;
    }
}
