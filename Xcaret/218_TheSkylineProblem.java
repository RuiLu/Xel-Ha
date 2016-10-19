public class Solution {
    /**
     *  Idea -> Take left point and right point apart, assign the left point a negative height
     *          Maintains a TreeMap to get current maximum height and overlaping buildings
     *  Time complexity -> O(nlogn), where n is doubled number of buildings
     *  Space complexity -> O(n)
     */
    public List<int[]> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length == 0 || buildings[0].length != 3) {
            return new ArrayList<int[]>();
        }
        
        List<int[]> heights = new ArrayList<>();
        List<int[]> skylines = new ArrayList<>();
        
        for (int[] building : buildings) {
            heights.add(new int[]{building[0], -building[2]});
            heights.add(new int[]{building[1], building[2]});
        }
        
        // sorting the heights in ascending order according to heights[0]
        Collections.sort(heights, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        tmap.put(0, 1);
        int previous = 0;
        
        for (int[] height : heights) {
            if (height[1] < 0) {
                Integer num = tmap.get(-height[1]);
                num = num == null ? 1 : num + 1;
                tmap.put(-height[1], num);
            } else {
                Integer num = tmap.get(height[1]);
                if (num == 1) tmap.remove(height[1]);
                else tmap.put(height[1], num - 1);
            }
            
            int current = tmap.lastKey();
            if (previous != current) {
                skylines.add(new int[]{height[0], current});
                previous = current;
            }
        }
        
        return skylines;
    }
}
