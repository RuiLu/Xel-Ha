public class Solution {
    /**
     *  Strobogrammatic number pairs are 0-0, 1-1, 6-9, 8-8.
     *  First step is to check n is even length of odd length.
     *  If n is odd length, we should add 0 or 1 or 8 in the middle.
     *  Then do recursion.
     * 
     *  Time complexity -> O(2^n)
     */
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", n);
        return res;
    }
    
    private void helper(List<String> res, String curr, int n) {
        if (n <= 0) {
            res.add(curr);
            return;
        }
        
        if (n%2 != 0) {
            helper(res, curr+"0", n-1);
            helper(res, curr+"1", n-1);
            helper(res, curr+"8", n-1);
        } else {
            // if we reach the outmost elements, we cannot add "0". Avoid creating "01810"=="1810"
            if (n-2 != 0) helper(res, "0"+curr+"0", n-2);
            helper(res, "1"+curr+"1", n-2);
            helper(res, "6"+curr+"9", n-2);
            helper(res, "9"+curr+"6", n-2);
            helper(res, "8"+curr+"8", n-2);
        }
    }
}
