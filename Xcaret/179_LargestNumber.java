public class Solution {
    /**
     *  Directly compare the combination of two strings, and sorted them in descending order
     *  Let's assume n is the length of nums, k is average length of number string
     *        1. compare two strings takes O(k), where k is the length of string
     *        2. sort a string takes O(klogk)
     *        3. sorted n strings takes O(nklogk)
     *        4. assign to StringBuilder takes O(n)
     *  So the total time is O(nklogk)
     */
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        
        String[] strs = new String[nums.length];
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        
        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String s1, String s2) {
                String sum1 = s1 + s2;
                String sum2 = s2 + s1;
                return sum2.compareTo(sum1);
            }
        });
        
        /* If all number is 0 */
        if (strs[0].charAt(0) == '0') return "0";
        
        for (String str : strs) sb.append(str);
        return sb.toString();
        
    }
}
