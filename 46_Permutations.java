/**
 *  DFS with backtracking
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        
        List<Integer> tmp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        
        dfs(nums, res, tmp, visited);
        
        return res;
    }
    
    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> tmp, boolean[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                tmp.add(nums[i]);
                visited[i] = true;
                dfs(nums, res, tmp, visited);
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
            }
        }
    }
}

