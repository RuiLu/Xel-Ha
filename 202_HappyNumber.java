public class Solution {
    /**
     *  Using a HashSet
     */
    public boolean isHappy(int n) {
        if (n < 0) return false;
        if (n == 1) return true;
        
        Set<Integer> set = new HashSet<>();
        
        while (set.add(n)) {
            int squareSum = 0;
            
            while (n > 0) {
                int remain = n % 10;
                squareSum += remain * remain;
                n /= 10;
            }
            
            if (squareSum == 1) return true;
            else n = squareSum;
        }
        
        return false;
    }
}
