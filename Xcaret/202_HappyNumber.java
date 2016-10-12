public class Solution {
    /**
     *  Idea -> Using a HashSet to keep track of duplicate res,
     *          if found one, which means we are in a infinite-loop, return false.
     */
    public boolean isHappy(int n) {
        if (n <= 0) return false;
        
        Set<Integer> set = new HashSet<>();
        int res = 0;
        String num = Integer.toString(n);
        
        while (res != 1) {
            if (!set.add(res)) return false;
            
            res = 0;
            for (int i = 0; i < num.length(); i++) {
                int val = num.charAt(i) - '0';
                res += val * val;
            }
            
            num = Integer.toString(res);
        }
        
        return true;
    }
}
