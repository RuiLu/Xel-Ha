public class Solution {
    /**
     *  Reference -> https://discuss.leetcode.com/topic/30453/java-very-straightforward-solution-with-detailed-explanation
     *  The tricky one is to check the length of second number
     */
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) return false;
        
        int len = num.length();
        
        /**
         *  Let's say first number is A, second number is B, and third number is C
         */
        
        /* A's length must be less than the half of total length */
        for (int i = 1; i <= (len-1)/2; i++) {
            if (num.charAt(0) == '0' && i >= 2) break;
            
            /* B's length is more tricky, because we need to make sure C's length is equal or bigger than  
               max(A.length, B.length), where A.length == i, B.length == j-i */
            for (int j = i+1; len-j >= j-i && len-j >= i; j++) {
                if (num.charAt(i) == '0' && j-i >= 2) break;
                
                long firstNum = Long.parseLong(num.substring(0, i));
                long secondNum = Long.parseLong(num.substring(i, j));
                String remain = num.substring(j);
                
                if (isAdditive(remain, firstNum, secondNum)) return true;
            }
        }
        
        return false;
    }
    
    private boolean isAdditive(String remain, long firstNum, long secondNum) {
        if (remain.equals("")) return true;
        
        long sum = firstNum + secondNum;
        String str = Long.toString(sum);
        if (!remain.startsWith(str)) return false;
        
        return isAdditive(remain.substring(str.length()), secondNum, sum);
    }
}
