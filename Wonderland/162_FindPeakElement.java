public class Solution {
    /**
     *  First attemp -> using TreeMap, accepted but takes a lot of time
     *  Time Complexity -> O(n) (we need to store the whole array into the map)
     */
    public int findPeakElement(int[] nums) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            treeMap.put(nums[i], i);
        }
        return treeMap.get(treeMap.firstKey());
    }
    
    /**
     *  Second attemp -> binary search 
     *  Time Complexity -> O(logn)
     */
    // 1. recursion
    public int findPeakElement(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }
    
    private int binarySearch(int[] nums, int left, int right) {
        if (left >= right) {
            return left;
        } else {
            int mid1 = (left + right) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] > nums[mid2]) return binarySearch(nums, left, mid1);
            else return binarySearch(nums, mid2, right);
        }
    }
    
    // 2. iteration
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid1 = (left + right) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] > nums[mid2]) right = mid1;
            else left = mid2;
        }
        
        return left;
    }
}
