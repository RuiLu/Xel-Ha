/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     *  1. Keep values in a list, and find k nearest values
     *  Time complexity -> O(n + k)
     *  Space complexity -> O(n + k)
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> tree = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        
        dfs(root, tree);
        
        int i = 0;
        for (; i < tree.size(); i++) if (1.0 * tree.get(i) > target) break;
        
        int left = i - 1, right = i, count = 0;
        
        while (left >= 0 && right < tree.size() && count < k) {
            if ((1.0 * tree.get(right) - target) >= (target - 1.0 * tree.get(left))) {
                res.add(tree.get(left--));
            } else {
                res.add(tree.get(right++));
            }
            count++;
        }
        
        while (left < 0 && right < tree.size() && count < k) {
            res.add(tree.get(right++));
            count++;
        }
        while (left >= 0 && right >= tree.size() && count < k) {
            res.add(tree.get(left--));
            count++;
        }
        
        return res;
    }
    
    private void dfs(TreeNode root, List<Integer> tree) {
        if (root == null) return;
        
        dfs(root.left, tree);
        tree.add(root.val);
        dfs(root.right, tree);
    }
    
    /**
     *  2. keep two stack, namely succ and pred
     *  Time complexity -> O(klogn)
     *  Space complexity -> O(n)
     *  Pred is always less than the current value, and Succ is always bigger than the current value.
     */
    private Stack<TreeNode> initSuccStack(TreeNode node, double target) {
        Stack<TreeNode> succ = new Stack<>();
        while (node != null) {
            if (node.val == target) {
                succ.push(node);
                break;
            } else if (node.val > target) {
                succ.push(node);
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return succ;
    } 
    
    private Stack<TreeNode> initPredStack(TreeNode node, double target) {
        Stack<TreeNode> pred = new Stack<>();
        while (node != null) {
            if (node.val == target) {
                pred.push(node);
                break;
            } else if (node.val < target) {
                pred.push(node);
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return pred;
    } 
     
    private int getNextSucc(Stack<TreeNode> succ) {
        TreeNode curr = succ.pop();
        int val = curr.val;
        curr = curr.right;
        while (curr != null) {
            succ.push(curr);
            curr = curr.left;
        }
        return val;
    }
    
    private int getNextPred(Stack<TreeNode> pred) {
        TreeNode curr = pred.pop();
        int val = curr.val;
        curr = curr.left;
        while (curr != null) {
            pred.push(curr);
            curr = curr.right;
        }
        return val;
    }
     
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> succ = initSuccStack(root, target);
        Stack<TreeNode> pred = initPredStack(root, target);
        
        // de-duplicate
        if (!succ.isEmpty() && !pred.isEmpty() && succ.peek().val == pred.peek().val) {
            getNextPred(pred);
        }
        
        while (k-- > 0) {
            if (succ.isEmpty()) {
                res.add(getNextPred(pred));
            } else if (pred.isEmpty()) {
                res.add(getNextSucc(succ));
            } else {
                double succDiff = Math.abs(1.0 * succ.peek().val - target);
                double predDiff = Math.abs(1.0 * pred.peek().val - target);
                
                if (succDiff <= predDiff) res.add(getNextSucc(succ));
                else res.add(getNextPred(pred));
            }
        }
        
        return res;
    }
 
}
