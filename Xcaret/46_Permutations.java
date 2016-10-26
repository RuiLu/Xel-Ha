public class Solution {
    /**
     *  Backtracking
     *  Time complexity -> O(n!)
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) return lists;
        List<Integer> tmp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(nums, lists, tmp, visited);
        return lists;
    }
    
    private void helper(int[] nums, List<List<Integer>> lists, List<Integer> tmp, boolean[] visited) {
        if (tmp.size() == nums.length) {
            lists.add(new ArrayList<>(tmp));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp.add(nums[i]);
                helper(nums, lists, tmp, visited);
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
            }
        }
    }
}
