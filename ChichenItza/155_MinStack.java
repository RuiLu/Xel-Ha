public class MinStack {

    class Item {
        
        int val;
        int min;
        
        public Item(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    private Stack<Item> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Item>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()) stack.push(new Item(x, x));
        else stack.push(new Item(x, Math.min(x, stack.peek().min)));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
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
