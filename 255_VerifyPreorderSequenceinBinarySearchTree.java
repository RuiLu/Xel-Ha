public class Solution {
    /**
     *  Using a stack
     *  Idea -> https://discuss.leetcode.com/topic/21217/java-o-n-and-o-1-extra-space
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length <= 1) return true;
        
        Stack<Integer> stack = new Stack<>();
        
        int low = Integer.MIN_VALUE;
        for (int val : preorder) {
            if (val < low) return false;
            
            while (!stack.isEmpty() && stack.peek() < val) {
                low = stack.pop();
            }
            
            stack.push(val);
        }
        
        return true;
    }
    
    /**
     *  Divied and Conquer
     *  Time complexity -> O(n)
     */
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length <= 1) return true;
        return verify(preorder, 0, preorder.length - 1);
    }
    
    private boolean verify(int[] preorder, int start, int end) {
        if (start >= end) return true;
        
        int pivot = preorder[start];
        int firstBigger = -1;
        
        for (int i = start + 1; i <= end; i++) {
            if (firstBigger == -1 && preorder[i] > pivot) firstBigger = i;
            if (firstBigger != -1 && preorder[i] < pivot) return false;
        }
        
        if (firstBigger == -1) return verify(preorder, start + 1, end);
        else return verify(preorder, start + 1, firstBigger - 1) && verify(preorder, firstBigger, end);
    }
}
