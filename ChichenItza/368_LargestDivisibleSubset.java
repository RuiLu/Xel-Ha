public class Solution {
    /**
     *  Idea -> Dynamic programming
     *  Time complexity -> O(n^2)
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length <= 0) return res;
        
        int len = nums.length;
        int max = 0;                    // Current maximal size of divisible subset
        int maxIdx = -1;                // Index that starts the maximal divisible subset
        int[] count = new int[len];     // The maximal size of subset that each element is in
        int[] parent = new int[len];    // Relations among elements in the same subset
        
        Arrays.sort(nums);              // nums should be sorted in ascending order
        
        for (int i = len-1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (nums[j]%nums[i] == 0 && count[i] < count[j]+1) {
                    count[i] = count[j]+1;
                    parent[i] = j;
                    if (count[i] > max) {
                        max = count[i];
                        maxIdx = i;
                    }
                }
            }
        }
        
        for (int i = 0; i < max; i++) {
            res.add(nums[maxIdx]);
            maxIdx = parent[maxIdx];
        }
        
        return res;
    }
}
