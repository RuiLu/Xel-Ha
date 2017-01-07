/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    /**
     *  Idea -> See comments.
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int findCelebrity(int n) {
        if (n <= 1) return -1;
        
        int candidate = 0;
        /* Find the celebrity candidate */
        for (int i = 1; i < n; i++) {
            if (!knows(i, candidate)) candidate = i;
        }
        
        /* Verify the candidate, 1. other people knows the candidate; 2. the candidate doesn't know others */
        for (int i = 0; i < n; i++) {
            if (i == candidate) continue;
            if (knows(candidate, i) || !knows(i, candidate)) return -1;
        }
        
        return candidate;
    }
}
