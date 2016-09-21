public class Solution {
    /**
     *  Backtracking
     *  Time complexity -> O(n!)
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        boolean[] visited = new boolean[nums.length];
        helper(res, nums, visited, new ArrayList<>());
        return res;
    }
    
    private void helper(List<List<Integer>> res, int[] nums, boolean[] visited, List<Integer> tmp) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp.add(nums[i]);
                helper(res, nums, visited, tmp);
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
            }
        }
    }
}
