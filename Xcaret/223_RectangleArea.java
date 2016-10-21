public class Solution {
    /**
     *  Idea -> deduct the overlap area, the tricky part is how to find the overlap part
     *  Reference -> https://discuss.leetcode.com/topic/15733/my-java-solution-sum-of-areas-overlapped-area/2
     */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaA = (C - A) * (D - B);
        int areaB = (G - E) * (H - F);

        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int up = Math.min(D, H);
        int down = Math.max(B, F);
        
        // if there is no overlap, then reduce 0
        int overlap = 0;
        if (right > left && up > down) {
            overlap = (right - left) * (up - down);
        }
        
        return areaA + areaB - overlap;
    }
}
