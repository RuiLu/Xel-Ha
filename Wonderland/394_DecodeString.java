public class Solution {
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

    /**
     *  Stack
     */
    public String decodeString(String s) {
        String res = "";
        if (s == null || s.length() == 0) return res;
        
        Stack<String> prevString = new Stack<>();
        Stack<Integer> count = new Stack<>();
        
        count.push(1);
        
        for (int i = 0; i < s.length();) {
            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                int start = i;
                while (Character.isDigit(s.charAt(++i)));
                int repeatTimes = Integer.valueOf(s.substring(start, i));
                count.push(repeatTimes);
            } else if (curr == '[') {
                prevString.push(res);
                res = "";
                i++;
            } else if (curr == ']') {
                StringBuilder sb = new StringBuilder(prevString.pop());
                int repeatTimes = count.pop();
                while (repeatTimes-- > 0) sb.append(res);
                res = sb.toString();
                i++;
            } else {
                res += curr;
                i++;
            }
        }
        
        return res;
    }
}
