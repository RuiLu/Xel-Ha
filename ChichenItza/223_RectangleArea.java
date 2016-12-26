public class Solution {
    /**
     *  Idea -> First determine whether this two rectangles are overlap.
     *          If no, calculate the overlap area, then calculate the total covered area.
     */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int overlapArea;
        
        if (A >= G || E >= C || B >= H || F >= D) {
            overlapArea = 0;
        } else {
            int height = Math.min(D, H) - Math.max(B, F);
            int width = Math.min(C, G) - Math.max(A, E);
            overlapArea = height * width;
        }
    
        return (D - B) * (C - A) + (H - F) * (G - E) - overlapArea;
    }
}
