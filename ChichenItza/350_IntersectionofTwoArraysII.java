public class Solution {
    /**
     *  Idea -> Using a HashMap
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        for (int j = 0; j < nums2.length; j++) {
            if (map.containsKey(nums2[j])) {
                list.add(nums2[j]);
                map.put(nums2[j], map.get(nums2[j]) - 1);
                if (map.get(nums2[j]) == 0) map.remove(nums2[j]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }
    
    /**
     *  Idea -> First sort both arrays, then compare elements one by one.
     *  Time complexity -> O(nlogn), where n is the longer length between nums1 and nums2.
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }
}
