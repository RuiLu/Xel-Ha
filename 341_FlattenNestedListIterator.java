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
public class NestedIterator implements Iterator<Integer> {

    /**
     *  2. using real iterator + stack
     *  
     *  Find ListIterator API from here -> https://docs.oracle.com/javase/7/docs/api/java/util/ListIterator.html
     */
    private Stack<ListIterator<NestedInteger>> stack;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        stack.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
       hasNext();
       return stack.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.empty()) {
            if (!stack.peek().hasNext()) {
                stack.pop();
            } else {
                NestedInteger curr = stack.peek().next();
                
                if (curr.isInteger()) return curr == stack.peek().previous();
                
                stack.push(curr.getList().listIterator());
            }
        }
        
        return false;
    }

    /**
     *  1. using stack
     */
    private Stack<NestedInteger> stack;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
      while (!stack.empty()) {
          NestedInteger curr = stack.peek();
           
          if (curr.isInteger()) {
              return true;
          }
           
          stack.pop();
           
          for (int i = curr.getList().size() - 1; i >= 0; i--) {
              stack.push(curr.getList().get(i));
          }
      }
       
      return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
