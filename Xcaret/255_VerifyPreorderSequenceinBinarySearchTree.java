public class Solution {
    /**
     *  Idea -> Divide and Conquer
     *  Time complexity -> O(n) in worst case
     *  Space complexity -> O(1)
     */
    private boolean verify(int[] preorder, int begin, int end) {
        if (begin >= end) return true;
        
        int firstBigger = -1;
        for (int i = begin; i <= end; i++) {
            if (firstBigger == -1 && preorder[i] > preorder[begin]) firstBigger = i;
            if (firstBigger != -1 && preorder[i] < preorder[begin]) return false;
        }
        
        if (firstBigger == -1) return verify(preorder, begin + 1, end);
        else return verify(preorder, begin + 1, firstBigger - 1) && verify(preorder, firstBigger, end);
    }
    
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length <= 1) return true;
        return verify(preorder, 0, preorder.length - 1);
    }
}
