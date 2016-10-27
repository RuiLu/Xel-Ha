public class Solution {
    /**
     *  The way to de-duplicates is to sort the array, and skip duplicates when traversing
     *  In fact, when facing duplicates, the duplicates that we use is the last one of duplicates.
     *  Time complexity -> O(n!)
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) return lists;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<Integer> tmp = new ArrayList<>();
        helper(nums, lists, tmp, visited);
        return lists;
    }
    
    private void helper(int[] nums, List<List<Integer>> lists, List<Integer> tmp, boolean[] visited) {
        if (tmp.size() == nums.length) {
            lists.add(new ArrayList<>(tmp));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
            
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
