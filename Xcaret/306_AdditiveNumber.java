public class Solution {
    public static boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) return false;
        
        int len = num.length();
        
        /**
         *  Let's say first number is a, second number is b, and third number is c.
         *  So the length of a must less than the half length of num.
         *  Assuming i is a's length and len is num's length,
         *  then j-i will be b's length and len-(j-i+i) = len-j will be c's length (tricky one)
         *  So len-j >= i and len-j >= j-i should be the condition.
         */
        
        for (int i = 1; i <= (len - 1) / 2; i++) {
            /* Avoid 01, 02,... */
            if (num.charAt(0) == '0' && i > 1) break;
            
            for (int j = i + 1; len - j >= i && len - j >= j - i; j++) {
                if (num.charAt(i) == '0' && j > i + 1) break;
                
                long a = Long.parseLong(num.substring(0, i));
                long b = Long.parseLong(num.substring(i, j));
                String remain = num.substring(j);
                
                if (isAdditive(remain, a, b)) return true;
            }
        }
        return false;
    }
    
    private static boolean isAdditive(String remain, long a, long b) {
        if (remain.equals("")) return true;
        
        long c = a + b;
        String sc = Long.toString(c);
        if (!remain.startsWith(sc)) return false;
        
        return isAdditive(remain.substring(sc.length()), b, c);
    }
}
