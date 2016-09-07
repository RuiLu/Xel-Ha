/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    /**
     *  2. Iteration, usting stack
     */
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        
        Stack<ListIterator<NestedInteger>> stack = new Stack<>();
        stack.push(nestedList.listIterator());
        int res = 0;
        
        
        while (!stack.isEmpty()) {
            if (!stack.peek().hasNext()) {
                stack.pop();
            } else {
                NestedInteger curr = stack.peek().next();
                
                if (curr.isInteger()) res += stack.size() * curr.getInteger();
                else {
                    stack.push(curr.getList().listIterator());
                }
            }
        }
        
        return res;
    }
    
    /**
     *  1. DFS - recursion
     */
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        
        int depth = 1;
        int[] res = new int[1];
        
        for (int i = 0; i < nestedList.size(); i++) {
            helper(depth, res, nestedList.get(i));
        }
        
        return res[0];
    }
    
    private void helper(int depth, int[] res, NestedInteger ni) {
        if (ni.isInteger()) {
            Integer val = ni.getInteger();
            res[0] += depth * val;
        } else {
            for (int i = 0; i < ni.getList().size(); i++) {
                helper(depth + 1, res, ni.getList().get(i));
            }
        }
    }
}
