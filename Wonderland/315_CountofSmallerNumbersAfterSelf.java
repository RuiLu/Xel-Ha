public class Solution {
    
    /**
     *  2. Binary search tree -> Time complexity -> O(nlongn) (in the worst case, the time complexity will be O(n^2))
     *  Reference -> https://discuss.leetcode.com/topic/31405/9ms-short-java-bst-solution-get-answer-when-building-bst
     */
    class BSTNode {
        int val;
        int leftSum = 0;
        int duplicate = 0;
        BSTNode left, right;
        public BSTNode(int val) { this.val = val; }
    }
    
    private int helper(int num, BSTNode node) {
        int sum = 0;
        
        // iteration
        while (node.val != num) {
            if (num < node.val) {
                if (node.left == null) node.left = new BSTNode(num);
                node.leftSum++;
                node = node.left;
            } else if (num > node.val) {
                sum += node.leftSum + node.duplicate;
                if (node.right == null) node.right = new BSTNode(num);
                node = node.right;
            }
        }
        
        node.duplicate++;
        return sum + node.leftSum;
    }
    
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<Integer>();
        
        Integer[] count = new Integer[nums.length];
        
        BSTNode root = new BSTNode(nums[nums.length - 1]);
        
        for (int i = nums.length - 1; i >= 0; i--) {
            count[i] = helper(nums[i], root);
        }
        
        return Arrays.asList(count);
    }
    
    /**
     *  1. BIT -> from end to start, count the number of elements whose value is less than current element
     *            from current to end;
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        
        int min = Integer.MAX_VALUE;    // record the min value of the array
        int max = Integer.MIN_VALUE;    // record the max value of the array, the length of BIT
        
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        
        int[] nums2 = new int[nums.length]; // nums2 will be an array with all elements are bigger then 0
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i] - min + 1;
            max = Math.max(max, nums2[i]);
        }
        
        int[] bit = new int[max + 1];
        
        for (int i = nums2.length - 1; i >= 0; i--) {
            res.add(0, get(nums2[i] - 1, bit)); // get the number of elements that are smaller than nums2[i]
            update(nums2[i], bit);              // add nums2[i] into bit
        }
        
        return res;
    }
    
    private int get(int index, int[] bit) {
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= index & (-index);
        }
        return sum;
    }
    
    private void update(int index, int[] bit) {
        while (index < bit.length) {
            bit[index]++;
            index += index & (-index);
        }
    }

}
