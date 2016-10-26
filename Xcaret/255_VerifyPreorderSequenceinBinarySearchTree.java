public class Solution {
    /**
     *  Idea -> Divide and Conquer
     *  Time complexity -> O(n) in worst case
     *  Space complexity -> O(1)
     */
    private boolean helper(int[] preorder, int start, int end) {
        if (start >= end) return true;
        
        int firstBigger = -1;
        int rootVal = preorder[start];
        
        for (int i = start + 1; i <= end; i++) {
            if (firstBigger == -1 && rootVal < preorder[i]) firstBigger = i;
            if (firstBigger != -1 && rootVal > preorder[i]) return false;
        }
        
        if (firstBigger == -1) return helper(preorder, start + 1, end);
        else return helper(preorder, start + 1, firstBigger - 1) && helper(preorder, firstBigger, end);
    }
    
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length <= 1) return true;
        return helper(preorder, 0, preorder.length - 1);
    }
}
