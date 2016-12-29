public class Solution {
    /**
     *  Naive way
     */
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) return addBinary(b, a);
        
        StringBuilder res = new StringBuilder(a).reverse();
        b = new StringBuilder(b).reverse().toString();
        
        for (int i = 0; i < b.length(); i++) {
            char curr = b.charAt(i);
            
            if (curr == '0') continue;
            
            if (res.charAt(i) == '0') {
                res.setCharAt(i, '1');
            } else {
                int j = i;
                while (j < res.length() && res.charAt(j) == '1') {
                    res.setCharAt(j++, '0');
                }
                if (j == res.length()) res.append('1');
                else res.setCharAt(j, '1');
            }
        }
        
        return res.reverse().toString();
    }
    
    /**
     *  Ref -> https://discuss.leetcode.com/topic/13698/short-ac-solution-in-java-with-explanation
     */
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            res.append(sum % 2);
            carry = sum / 2;
        }
        
        if (carry != 0) res.append(carry);
        
        return res.reverse().toString();
    }
}
