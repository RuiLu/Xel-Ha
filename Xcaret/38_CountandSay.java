public class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        
        String res = "1";
        
        while (--n > 0) {
            int count = 1;
            char prev = res.charAt(0);
            StringBuilder sb = new StringBuilder();
            
            for (int i = 1; i < res.length(); i++) {
                char curr = res.charAt(i);
                
                if (curr != prev) {
                    sb.append(count);
                    sb.append(prev);
                    count = 0;
                    prev = curr;
                }
                
                count++;
            }
            
            sb.append(count);
            sb.append(prev);
            res = sb.toString();
        }
        
        return res;
    }
}
