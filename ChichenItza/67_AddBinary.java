public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || b == null) return null;
        
        int carry = 0;
        String res = "";
        
        for (int i = a.length()-1, j = b.length()-1; i >= 0 || j >= 0; i--, j--) {
            char ac = '0';
            char bc = '0';
            if (i >= 0) ac = a.charAt(i);
            if (j >= 0) bc = b.charAt(j);
            
            int sum = carry + (ac-'0') + (bc-'0');
            carry = sum/2;
            res = sum%2 + res;
        }
        
        if (carry == 1) res = "1"+res;
        
        return res;
    }
}
