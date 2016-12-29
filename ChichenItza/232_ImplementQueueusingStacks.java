class MyQueue {
    
    private Stack<Integer> pushStack = new Stack<Integer>();
    private Stack<Integer> getStack = new Stack<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        while (!getStack.isEmpty()) pushStack.push(getStack.pop());
        pushStack.push(x);
        while (!pushStack.isEmpty()) getStack.push(pushStack.pop());
    }

    // Removes the element from in front of queue.
    public void pop() {
        getStack.pop();
    }

    // Get the front element.
    public int peek() {
        if (getStack.isEmpty()) return 0;
        return getStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return getStack.isEmpty();
    }
}
