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
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) candidate = i;
        }
        
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (knows(candidate, i) || !knows(i, candidate)) return -1;
            }
        }
        
        return candidate;
    }
}
