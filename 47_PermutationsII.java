public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums); // We need to sort the array first!
        getAllPermutations(res, nums, new ArrayList<Integer>(), new boolean[nums.length]);
        return res;
    }
    
    private static void getAllPermutations(List<List<Integer>> res, int[] nums, List<Integer> temp, boolean[] used) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<Integer>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                if (!used[i]) {
                    used[i] = true;
                    temp.add(nums[i]);
                    getAllPermutations(res, nums, temp, used);
                    used[i] = false;
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
    
}
