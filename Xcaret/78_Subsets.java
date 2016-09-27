public class Solution {
    /**
     *  Backtracking, no need for sorting because numbers in nums are distinct
     *  It will produce 2^n subsets in total, and we can assume that every subset has length n
     *  Time complexity -> O(n*2^n)
     *  Analysis reference -> http://www.1point3acres.com/bbs/thread-117602-1-1.html
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        helper(res, nums, 0, new ArrayList<>());
        return res;
    }
    
    private void helper(List<List<Integer>> res, int[] nums, int start, List<Integer> tmp) {
        if (start == nums.length) {
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            res.add(new ArrayList<>(tmp));
            helper(res, nums, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
