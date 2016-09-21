public class Solution {
    /**
     *  The way to de-duplicates is to sort the array, and skip duplicates when traversing
     *  In fact, when facing duplicates, the duplicates that we use is the last one of duplicates.
     *  Time complexity -> O(n!)
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<Integer> tmp = new ArrayList<>();
        
        helper(res, nums, visited, tmp);
        
        return res;
    }
    
    private void helper(List<List<Integer>> res, int[] nums, boolean[] visited, List<Integer> tmp) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            /* if there exists duplicates and more than one of them are not used before, we SKIP */
            if (i > 0 && !visited[i-1] && nums[i-1] == nums[i]) continue;
            
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
