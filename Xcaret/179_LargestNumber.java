public class Solution {
    /**
     *  Directly compare the combination of two strings, and sorted them in descending order
     *  Let's assume n is the length of nums, k is average length of number string
     *        1. compare two strings takes O(k)
     *        2. sorted n strings takes O(nklognk)
     *        3. assign to StringBuilder takes O(n)
     *  So the total time is O(nklognk)
     */
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        
        int len = nums.length;
        String[] strs = new String[len];
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < len; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String s1, String s2) {
                String sum1 = s1 + s2;
                String sum2 = s2 + s1;
                return sum2.compareTo(sum1);
            }
        });
        
        /* We should pay attention to the all-zero situation */
        if (strs[0].charAt(0) == '0') return "0";
        
        for (String str : strs) {
            sb.append(str);
        }
        
        return sb.toString();
    }
}
