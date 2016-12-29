/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    /**
     *  Two passes
     *  First pass is to pick up the candidate,
     *  second pass is to check is the selected candidate is real
     */
    public int findCelebrity(int n) {
        int candidate = 0;
        /* First, find the celebrity candidate */
        for (int i = 1; i < n; i++) {
            if (!knows(i, candidate)) candidate = i;
        }
        /* Then, check if this selected candidate is real celebrity */
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                /* If this candidate knows others, or other doesn't know this candidate, then fake. */
                if (knows(candidate, i) || !knows(i, candidate)) return -1;
            }
        }
        return candidate;
    }
}
