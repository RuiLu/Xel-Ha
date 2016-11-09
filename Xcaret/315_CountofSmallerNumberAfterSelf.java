public class Solution {
    /**
     *  Idea -> Using Binary Index Tree
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        
        int min = Integer.MAX_VALUE;    /* The minimal element in nums, use to make nums non-negative */
        int max = Integer.MIN_VALUE;    /* Use to create bit array */
        
        for (int num : nums) {
            min = Math.min(min, num);
        }
        
        int[] nums2 = new int[nums.length]; /* nums2 will be an array with all elements are bigger then 0 */
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i] - min + 1;
            max = Math.max(max, nums2[i]);
        }
        
        int[] bit = new int[max+1];
        
        for (int i = nums2.length - 1; i >= 0; i--) {
            list.add(0, get(nums2[i] - 1, bit)); /* Get the number of elements that are smaller than nums2[i] */
            update(nums2[i], bit);  /* Add nums2[i] into bit array */
        }
        
        return list;
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
    
    /**
     *  Idea -> Binary Search Tree
     */
    private class BSTNode {
        int val = 0;
        int duplicates = 0;
        int leftSum = 0;
        BSTNode left = null;
        BSTNode right = null;
        
        public BSTNode(int val) {
            this.val = val;
        }
    } 
    
    private int helper(int val, BSTNode node) {
        int sum = 0;
        
        while (node.val != val) {
            if (val < node.val) {
                if (node.left == null) node.left = new BSTNode(val);
                node.leftSum++;
                node = node.left;
            } else if (val > node.val) {
                sum += node.leftSum + node.duplicates;
                if (node.right == null) node.right = new BSTNode(val);
                node = node.right;
            }
        }
        
        node.duplicates++;
        
        return sum + node.leftSum;
    }
     
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        
        BSTNode root = new BSTNode(nums[nums.length - 1]);
        
        for (int i = nums.length - 1; i >= 0; i--) {
            list.add(0, helper(nums[i], root));
        }
        
        return list;
    } 
     
}
