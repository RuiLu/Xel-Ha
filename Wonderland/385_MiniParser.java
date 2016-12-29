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
     * Iteration
     */
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') return new NestedInteger(Integer.valueOf(s));
        
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger curr = null;
        int l = 0;
        
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (ch == '[') {
                if (curr != null) stack.push(curr);
                
                curr = new NestedInteger();
                l = r + 1;
            } else if (ch == ']') {
                String num = s.substring(l, r);
                if (l != r) curr.add(new NestedInteger(Integer.valueOf(num)));
                if (!stack.isEmpty()) {
                    NestedInteger prev = stack.pop();
                    prev.add(curr);
                    curr = prev;
                }
                l = r + 1;
            } else if (ch == ',') {
                if (s.charAt(r - 1) != ']') {
                    String num = s.substring(l, r);
                    if (l != r) curr.add(new NestedInteger(Integer.valueOf(num)));
                }
                l = r + 1;
            }
        }
        
        return curr;
    }
    
    /**
     *  Recursion
     */
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') return new NestedInteger(Integer.valueOf(s));
        
        NestedInteger res = new NestedInteger();
        int l = 1;
        
        for (int r = 1, cnt = 0; r < s.length() - 1; r++) {
            if (s.charAt(r) == '[') cnt++;
            else if (s.charAt(r) == ']') cnt--;
            else if (s.charAt(r) == ',' && cnt == 0) {
                res.add(deserialize(s.substring(l, r)));
                l = r + 1;
            }
        }
        
        // In case there is '[]'
        if (l < s.length() - 1) res.add(deserialize(s.substring(l, s.length() - 1)));
        
        return res;
    }
}
