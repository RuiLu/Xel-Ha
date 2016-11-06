/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    /**
     *  Idea -> Find the candidate, and test if it is real celebrity
     *  Time complexity -> O(n)
     */ 
    public int findCelebrity(int n) {
        if (n <= 1) return 0;
        
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (!knows(i, candidate)) candidate = i;
        }
        
        /* validate if this candidate is real celebrity */
        for (int i = 0; i < n; i++) {
            if (i == candidate) continue;
            if (knows(candidate, i) || !knows(i, candidate)) return -1;
        }
        
        return candidate;
    }
}
