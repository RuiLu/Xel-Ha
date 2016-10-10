public class Solution {
    /**
     *  Time complexity -> O(log26(n)) -> base of log is 26
     */
    public String convertToTitle(int n) {
        if (n <= 0) return null;
        StringBuilder sb = new StringBuilder();
        
        while (n != 0) {
            int remainder = n % 26 - 1;
            n /= 26;
            if (remainder == -1) {
                sb.insert(0, 'Z');
                n--;
            } else {
                sb.insert(0, (char)('A' + remainder));
            }
        }
        
        return sb.toString();
    }
}
