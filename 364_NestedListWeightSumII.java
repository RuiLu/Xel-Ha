/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    /**
     *  No depth variable and no multiplication
     *  Reference -> https://discuss.leetcode.com/topic/49041/no-depth-variable-no-multiplication
     *  Brilliant idea! [1,[4,[6]]] -> 1 * 3 + 4 * 2 + 6 * 1 -> 1 + (1 + 4) + (1 + 4 + 6)
     */
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        
        int weighted = 0, unweighted = 0;
        
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<>();
            
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger()) unweighted += ni.getInteger();
                else {
                    nextLevel.addAll(ni.getList());
                }
            }
            
            weighted += unweighted;
            nestedList = nextLevel;
        }
        
        return weighted;
    }
    
    /**
     *  Iterstion, using a Map<Integer, List<Integer>> to record each layers num, then do calculation
     */
    // public int depthSumInverse(List<NestedInteger> nestedList) {
    //     if (nestedList == null || nestedList.size() == 0) return 0;
        
    //     Stack<Iterator<NestedInteger>> stack = new Stack<>();
    //     Map<Integer, List<Integer>> map = new HashMap<>();
    //     int res = 0;
    //     int maxDepth = 1;
        
    //     stack.push(nestedList.iterator());
        
    //     while (!stack.isEmpty()) {
    //         if (!stack.peek().hasNext()) {
    //             stack.pop();
    //         } else {
    //             NestedInteger curr = stack.peek().next();
                
    //             if (curr.isInteger()) {
    //                 int depth = stack.size();
    //                 maxDepth = Math.max(maxDepth, depth);
    //                 Integer val = curr.getInteger();
    //                 if (!map.containsKey(depth)) map.put(depth, new ArrayList<>());
    //                 map.get(depth).add(val);
    //             } else {
    //                 stack.push(curr.getList().iterator());
    //             }
    //         }
    //     }
        
        
    //     for (int depth : map.keySet()) {
    //         int weight = maxDepth - depth + 1;
    //         for (int num : map.get(depth)) res += weight * num;
    //     }
        
    //     return res;
    // }
}
