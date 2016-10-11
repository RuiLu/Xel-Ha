public class Solution {
    /**
     *  Time complexity -> O(log26(n)) -> base of log is 26
     */
    public String convertToTitle(int n) {
        if (n <= 0) return "";
        
        StringBuilder sb = new StringBuilder();
        
        while (n != 0) {
            int value = n % 26;
            if (value == 0) {
                sb.insert(0, 'Z');
                n--;
            } else {
                sb.insert(0, (char)('A' + value - 1));
            }
            n /= 26;
        }
        
        return sb.toString();
    }
}
