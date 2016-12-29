public class Solution {
    /**
     *  Time complexity -> O(n)
     */ 
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        
        int[] ba = new int[10];
        int[] ca = new int[10];
        
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            
            if (s == g) {
                bulls++;
            } else {
                ba[s - '0']++;
                ca[g - '0']++;
            }
        }
        
        for (int i = 0; i < ba.length; i++) {
            cows += Math.min(ba[i], ca[i]);
        }
        
        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }
}
