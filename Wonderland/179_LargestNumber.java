public class Solution {
    /**
     *  Time complexity ->  Let's assume n is the length of nums, k is the average length of number
     *                      1. compare two strings -> O(k)
     *                      2. sort the array -> O(nklognk)
     *                      3. stringbuilder append -> O(n)
     *                      Total -> O(nklognk) + O(n) -> O(nklognk)
     *  Space complexity -> O(n)
     *  Directly compare combination STRING of two numbers
     *  Reference -> https://discuss.leetcode.com/topic/8018/my-java-solution-to-share/2
     */
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        
        if (nums == null || nums.length == 0) return sb.toString();
        
        String[] strs = new String[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String s1, String s2) {
                String sum1 = s1 + s2;
                String sum2 = s2 + s1;
                return sum2.compareTo(sum1);
            }
        });
        
        if (strs[0].charAt(0) == '0') {
            return "0";
        }
        
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        
        return sb.toString();
    }
}
