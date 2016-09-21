public class Solution {
    public String countAndSay(int n) {
        if (n < 1) return "";
        String res = "1";
        
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            char prev = res.charAt(0);
            int count = 1;
            
            for (int i = 1; i < res.length(); i++) {
                char curr = res.charAt(i);
                
                if (prev != curr) {
                    sb.append(count);
                    sb.append(prev);
                    
                    prev = res.charAt(i);
                    count = 0;
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
