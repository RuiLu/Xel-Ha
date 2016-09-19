public class Solution {
    /**
     *  Add sum one character by one charater
     *  Then deduct some special cases like "IV", "IX", etc
     */
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int res = 0;
        
        /* Add each value of character one by one */
        for (char ch : s.toCharArray()) {
            if (ch == 'M') res += 1000;
            else if (ch == 'D') res += 500;
            else if (ch == 'C') res += 100;
            else if (ch == 'L') res += 50;
            else if (ch == 'X') res += 10;
            else if (ch == 'V') res += 5;
            else if (ch == 'I') res += 1;
        }
        
        /* Find and Deduct each special cases */
        if (s.indexOf("IV") != -1) res -= 2;
        if (s.indexOf("IX") != -1) res -= 2;
        if (s.indexOf("XL") != -1) res -= 20;
        if (s.indexOf("XC") != -1) res -= 20;
        if (s.indexOf("CD") != -1) res -= 200;
        if (s.indexOf("CM") != -1) res -= 200;
        
        return res;
    }
}
