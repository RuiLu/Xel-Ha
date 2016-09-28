public class Solution {
    /**
     *  Reference -> https://discuss.leetcode.com/topic/1011/what-is-the-best-solution-for-gray-code-problem-no-extra-space-used-and-no-recursion/2
     * 
     *  Time complexity -> O(2^n)
     *  Idea: start from 0 , then add 1, (xx) means the base:
     *        0 -> 
     *        (1) 0, 1 -> 
     *        (10) -> 00, 01, 10, 11 -> 
     *        (100) -> 000, 001, 010, 011, 100, 101, 110, 111
     *        (1000) -> 0000, 0001, 0010, 0011, 0100, 0101, 0110, 0111, 1000, ... , 1111
     *        so on and so forth
     */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        
        for (int i = 0; i < n; i++) {
            int tmp = 1 << i;
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(res.get(j) + tmp);
            }
        }
        
        return res;
    }
}
