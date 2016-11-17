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
        if (nums == null || nums.length == 0) return res;
        helper(nums, res, new ArrayList<>(), 0);
        return res;
    }
    
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> tmp, int start) {
        if (start == nums.length) return;
        
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            res.add(new ArrayList<>(tmp));
            helper(nums, res, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
