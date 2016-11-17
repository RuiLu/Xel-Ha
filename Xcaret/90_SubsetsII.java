public class Solution {
    /**
     *  Backtracking
     *  Time complexity -> O(2^n)
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        helper(res, nums, new ArrayList<>(), new boolean[nums.length], 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, int[] nums, List<Integer> tmp, boolean[] visited, int start) {
        if (start == nums.length) return;
        
        for (int i = start; i < nums.length; i++) {
            /* Avoid duplicate */
            if (i > 0 && !visited[i-1] && nums[i-1] == nums[i]) continue;
            visited[i] = true;
            tmp.add(nums[i]);
            res.add(new ArrayList<>(tmp));
            helper(res, nums, tmp, visited, i + 1);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
        }
    }
}
