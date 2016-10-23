public class Solution {
    /**
     *  No much idea...
     */
    public int addDigits(int num) {
        if (num < 10) return num;
        
        while (num >= 10) {
            int tmp = 0;
            while (num > 0) {
                tmp += num % 10;
                num /= 10;
            }
            num = tmp;
        }
        
        return num;
    }
}
