public class Solution {
    /**
     *  Using a HashSet
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        
        int sum = 0;
        
        while (set.add(n)) {
            sum = 0;
            
            while (n > 0) {
                int remain = n % 10;
                sum += remain * remain;
                n /= 10;
            }
            
            if (sum == 1) return true;
            
            n = sum;
        }
        
        return false;
    }
}
