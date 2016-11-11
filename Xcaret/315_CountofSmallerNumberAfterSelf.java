public class Solution {
    /**
     *  Idea -> Using Binary Search Tree
     */
    private class BSTNode {
        int val = 0;
        int leftSum = 0;
        int duplicates = 0;
        BSTNode left = null;
        BSTNode right = null;
        
        public BSTNode(int val) {
            this.val = val;
        }
    }
    
    private int buildBST(BSTNode node, int val) {
        int sum = 0;
        
        while (node.val != val) {
            if (node.val < val) {
                sum += node.leftSum + node.duplicates;
                if (node.right == null) node.right = new BSTNode(val);
                node = node.right;
            } else {
                node.leftSum++;
                if (node.left == null) node.left = new BSTNode(val);
                node = node.left;
            }
        }
        
        node.duplicates++;
        sum += node.leftSum;
        return sum;
    }
     
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        
        BSTNode root = new BSTNode(nums[nums.length-1]);
        
        for (int i = nums.length - 1; i >= 0; i--) {
            int sum = buildBST(root, nums[i]);
            list.add(0, sum);
        }
        
        return list;
    }

    /**
     *  Idea -> Binary Index Tree
     */
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
     
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        
        int len = nums.length;
        int min = Integer.MAX_VALUE;    /* record the min value of the array */
        int max = Integer.MIN_VALUE;    /* record the max value of the array, the length of BIT */
        int[] nums2 = new int[len];     /* nums2 will be an array with all elements are bigger then 0 */
        
        for (int num : nums) min = Math.min(min, num);
        
        for (int i = 0; i < len; i++) {
            nums2[i] = nums[i] - min + 1;
            max = Math.max(max, nums2[i]);
        }
        
        int[] bit = new int[max+1];
        
        for (int i = len - 1; i >= 0; i--) {
            list.add(0, get(nums2[i] - 1, bit)); /* get the number of elements that are smaller than nums2[i] */
            update(nums2[i], bit);               /* add nums2[i] into bit */
        }
        
        return list;
    } 
     
}
