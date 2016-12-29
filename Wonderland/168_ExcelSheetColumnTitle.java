public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int remainder = n % 26 - 1;
            n /= 26;
            if (remainder == -1) {
                sb.append('Z');
                n--;
            } else {
                sb.append((char)(remainder + 'A'));
            }
        }
        return sb.reverse().toString();
    }
}
