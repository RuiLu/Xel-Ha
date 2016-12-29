public class Solution {
    /**
     *  Math. 
     *  Reference -> https://discuss.leetcode.com/topic/47983/java-dp-o-1-solution
     *  Time complexity -> O(n)
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        
        int res = 10;
        int uniqueDigits = 9;
        int availableDigits = 9;
        
        while (n-- > 1 && availableDigits > 0) {
            uniqueDigits = uniqueDigits * availableDigits;
            res += uniqueDigits;
            availableDigits--;
        }
        
        return res;
    }
}
