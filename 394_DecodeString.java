c class Solution {
    /**
     *  Recursion
     */
    public String decodeString(String s) {
        String res = "";
        if (s == null || s.length() == 0) return res;
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr > '9' || curr < '0') {
                res += curr;
            } else {
                int start = i++;
                int flag = 0, par = -1;
                
                for (; i < s.length(); i++) {
                    if (s.charAt(i) == '[') {
                        if (par == -1) par = i;
                        flag++;
                    }
                    if (s.charAt(i) == ']') flag--;
                    if (flag == 0 && par != -1) break;
                }
                
                int num = Integer.valueOf(s.substring(start, par));
                String duplicates = decodeString(s.substring(par + 1, i));
                while (num-- > 0) res += duplicates;
                
            }
        }
        
        return res;
    }
}
