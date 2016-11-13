class MyQueue {
    /**
     *  Idea -> Using one Stack
     */
    private Stack<Integer> stack = new Stack<>();
    
    public void push(int x) {
        Stack<Integer> tmp = new Stack<>();
        while (!stack.isEmpty()) {
            tmp.push(stack.pop());
        }
        stack.push(x);
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int peek() {
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
    
    /**
     *  Idea -> Using two stacks, inStack and outStack
     *          We update outStack only when pop() and peek() while outStack is empty, 
     *          and move elements from inStack to outStack
     */
    private Stack<Integer> inStack = new Stack<Integer>();
    private Stack<Integer> outStack = new Stack<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        inStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) outStack.push(inStack.pop());
        }
        if (!outStack.isEmpty()) outStack.pop();
    }

    // Get the front element.
    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) outStack.push(inStack.pop());
        }
        if (!outStack.isEmpty()) return outStack.peek();
        return 0;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
