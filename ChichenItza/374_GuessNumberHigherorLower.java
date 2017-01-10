/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    /**
     *  Binary search
     *  Time complexity -> O(logn)
     */
    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;
        while (lo <= hi) {
            int mid = lo+(hi-lo)/2;     // why does (lo+hi)/2 cause TLE????
            if (guess(mid) == 0) return mid;
            else if (guess(mid) == -1) hi = mid-1;
            else if (guess(mid) == 1) lo = mid+1;
        }
        return lo;
    }
}
