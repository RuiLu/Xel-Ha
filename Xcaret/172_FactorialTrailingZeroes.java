public class Solution {
    /**
     *  Reference -> https://discuss.leetcode.com/topic/6516/my-one-line-solutions-in-3-languages
     *  Time complexity -> O(log5(n)), base is 5
     */
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
