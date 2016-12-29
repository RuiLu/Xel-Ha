public class Solution {
    public String reverseString(String s) {
        
        int len = s.length();
        if (len == 1) return s;
        
        char[] ch = new char[len];
        
        for (int i = 0; i < len; i++) {
            ch[len - 1 - i] = s.charAt(i);
        }
        
        return new String(ch);
    }
}
