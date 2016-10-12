public class Solution {
    /**
     *  Idea -> Sieve of Eratosthenes
     *          * if we use set, Still Time Limited Exceeded...
     *          * so we need to use a boolean array to work as a set
     *  Reference -> https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
     */
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        
        int res = 0;
        boolean[] notPrime = new boolean[n];
        
        for (int i = 2; i < n; i++) {
            if (notPrime[i]) continue;
            
            res++;
            int iter = i;
            
            while (iter < n) {
                notPrime[iter] = true;
                iter += i;
            }
        }
        
        return res;
    }
}
