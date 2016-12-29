/**
 *  The way to de-duplicates is to sort the array, and skip duplicates when traversing
 *  In fact, when facing duplicates, the duplicates that we use is the last one of duplicates.
 */
public class Solution {
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        
        Arrays.sort(nums);  // It's important to sort the array first.
        List<Integer> tmp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        
        dfs(nums, res, tmp, visited);
        
        return res;
    }
    
    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> tmp, boolean[] visited) {
        if (nums.length == tmp.size()) {
            System.out.println(tmp);
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
                if (!visited[i]) {
                    visited[i] = true;
                    tmp.add(nums[i]);
                    dfs(nums, res, tmp, visited);
                    tmp.remove(tmp.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }
    
}
