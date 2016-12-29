public class Solution {
    
    // First -> Easy math.
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;
        while (num != 1) {
            if (num % 2 == 0) num /= 2;
            else if (num % 3 == 0) num /= 3;
            else if (num % 5 == 0) num /= 5;
            else return false;
        }
        return true;
    }
    
    // Second -> StackOverflowError, of course!
    // public boolean isUgly(int num) {
    //     if (num == 1 || num == 2 || num == 3 || num == 5) return true;
    //     if (num % 2 != 0 || num % 3 != 0 || num % 5 != 0) return false;
    //     return isUgly(num / 2) || isUgly(num / 3) || isUgly(num / 5);
    // }
}
