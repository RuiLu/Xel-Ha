/**
 * Using TreeMap for ordering and keep values in pair.
 */ 
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
       List<int[]> heights = new ArrayList<>();
       List<int[]> skylines = new ArrayList<>();
       
       for (int[] building : buildings) {
           heights.add(new int[]{building[0], -building[2]});
           heights.add(new int[]{building[1], building[2]});
       }
       
       Collections.sort(heights, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
       
       TreeMap<Integer, Integer> treeMap = new TreeMap<>(); // Ascending order
       treeMap.put(0, 1);
       int prevHeight = 0;
       
       for (int[] height : heights) {
           if (height[1] < 0) {
               Integer cnt = treeMap.get(-height[1]); // Integer is able to equal to null, int is not allowed
               cnt = cnt == null ? 1 : cnt + 1;
               treeMap.put(-height[1], cnt);
           } else {
               Integer cnt = treeMap.get(height[1]);
               if (cnt == 1) treeMap.remove(height[1]);
               else treeMap.put(height[1], cnt - 1);
           }
           
           int currHeight = treeMap.lastKey();
           if (prevHeight != currHeight) {
               skylines.add(new int[]{height[0], currHeight});
               prevHeight = currHeight;
           }
       }
       
       return skylines;
    }
}
