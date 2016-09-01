public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new LinkedList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] > nums2[j]) j++;
            else if (nums1[i] < nums2[j]) i++;
            else {
                list.add(nums1[i++]);
                while (i < nums1.length && nums1[i] == nums1[i-1]) i++;
                if (i == nums1.length) break;
                j++;
                while (j < nums2.length && nums2[j] == nums2[j-1]) j++;
                if (j == nums2.length) break;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) res[i] = list.get(i);
        return res;
    }
}
