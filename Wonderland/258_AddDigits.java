public class Solution {
    public int addDigits(int num) {
        // String str = Integer.toString(num);
        // while (str.length() != 1) {
        //     int n = 0;
        //     for (int i = 0; i < str.length(); i++) {
        //         n += str.charAt(i) - '0';
        //     }
        //     str = Integer.toString(n);
        // }
        // return Integer.parseInt(str);
        
        if (num < 10) {
            return num;
        } else if (num % 9 == 0) {
            return 9;
        } else {
            return num % 9;
        }
    }
}
