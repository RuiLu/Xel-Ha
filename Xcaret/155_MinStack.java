public class MinStack {
    /**
     *  Create an inner class Item, which stores its value and current minimum value
     *  Time complexity -> O(1) for all methods
     */
    private Stack<Item> stack;
    
    private class Item {
        int val;
        int min;
        
        public Item(int val) {
            this.val = val;
        }
        
        public void setMin(int min) {
            this.min = min;
        }
    }

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        Item item = new Item(x);
        if (stack.isEmpty()) {
            item.setMin(x);
        } else {
            int min = Math.min(x, stack.peek().min);
            item.setMin(min);
        }
        stack.push(item);
    }
    
    public void pop() {
        if (!stack.isEmpty()) stack.pop();
    }
    
    public int top() {
        if (stack.isEmpty()) return -1;
        return stack.peek().val;
    }
    
    public int getMin() {
        if (stack.isEmpty()) return -1;
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
