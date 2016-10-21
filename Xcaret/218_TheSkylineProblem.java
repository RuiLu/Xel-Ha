public class Solution {
    /**
     *  Idea -> Take left point and right point apart, assign the left point a negative height
     *          Maintains a TreeMap to get current maximum height and overlaping buildings
     *  Time complexity -> O(nlogn), where n is doubled number of buildings
     *  Space complexity -> O(n)
     */
    public List<int[]> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return new ArrayList<int[]>();
        }
        
        List<int[]> heights = new ArrayList<int[]>();
        List<int[]> skylines = new ArrayList<int[]>();
        
        for (int[] building : buildings) {
            heights.add(new int[]{building[0], -building[2]});
            heights.add(new int[]{building[1], building[2]});
        }
        
        Collections.sort(heights, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        
        TreeMap<Integer, Integer> tmap = new TreeMap<Integer, Integer>();
        tmap.put(0, -1);
        int prevHeight = 0;
        
        for (int[] height : heights) {
            if (height[1] < 0) {
                if (!tmap.containsKey(-height[1])) tmap.put(-height[1], 0);
                tmap.put(-height[1], tmap.get(-height[1]) + 1);
            } else {
                tmap.put(height[1], tmap.get(height[1]) - 1);
                if (tmap.get(height[1]) == 0) tmap.remove(height[1]);
            }
            
            int currHeight = tmap.lastKey();
            
            if (prevHeight != currHeight) {
                skylines.add(new int[]{height[0], currHeight});
                prevHeight = currHeight;
            }
        }
        
        return skylines;
    }
}
