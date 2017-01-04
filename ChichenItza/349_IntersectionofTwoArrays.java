public class Solution {
    /**
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < nums1.length; i++) set.add(nums1[i]);
        for (int i = 0; i < nums2.length; i++) {
            if (set.remove(nums2[i])) list.add(nums2[i]);
        }
        
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
        
        return res;
    }
}
