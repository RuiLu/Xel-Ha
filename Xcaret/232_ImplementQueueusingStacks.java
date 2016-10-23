class MyQueue {
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
