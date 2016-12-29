public class Solution {
    /**
     *  1. HashMap
     *  Time complexity -> O(n)
     *  Space complexity -> O(3n)
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i1 : nums1) {
            if (!map.containsKey(i1)) map.put(i1, 1);
            else map.put(i1, map.get(i1) + 1);
        }
        for (int i2 : nums2) {
            if (map.containsKey(i2)) {
                list.add(i2);
                map.put(i2, map.get(i2) - 1);
                if (map.get(i2) == 0) map.remove(i2);
            }
        }
        
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }
    
    /**
     *  2. Sort
     *  Time complexity -> O(nlogn)
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> list = new LinkedList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] > nums2[j]) j++;
            else if (nums1[i] < nums2[j]) i++;
            else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
        
        return res;
    }
}
