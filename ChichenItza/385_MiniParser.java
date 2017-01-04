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
     *  Idea -> Recursion
     */
    public NestedInteger deserialize(String s) {
        // If the given String s is a single number.
        if (s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));
        
        NestedInteger ni = new NestedInteger();
        int l = 1;
        int cnt = 0;    // cnt indicates the number of  '[' and ']' pairs.
        
        for (int r = 1; r < s.length() - 1; r++) {
            if (s.charAt(r) == '[') cnt++;
            else if (s.charAt(r) == ']') cnt--;
            else if (s.charAt(r) == ',' && cnt == 0) {
                ni.add(deserialize(s.substring(l, r)));
                l = r + 1;
            }
        }
        
        // If l cannot reach the end, we should deal with the substring between l and s.length()-1
        if (l < s.length() - 1) ni.add(deserialize(s.substring(l, s.length()-1)));
        
        return ni;
    }
}
