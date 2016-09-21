public class Solution {
    /**
     *  Reference -> https://discuss.leetcode.com/topic/30508/easiest-java-solution-with-graph-explanation
     *  The result of nums[i] * nums[j] will be placed at i+j and i+j+1
     *  Time complexity -> O(mn)
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        
        int len1 = num1.length();
        int len2 = num2.length();
        int[] nums = new int[len1+len2];
        
        for (int i = len1-1; i >= 0; i--) {
            for (int j = len2-1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                mul += nums[p2];
                
                nums[p1] += mul/10;
                nums[p2] = mul%10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            if (sb.length() == 0 && num == 0) continue;
            sb.append(num);
        }
        
        return sb.toString();
    }
}
