class MyStack {
    
    private Deque<Integer> deque = new ArrayDeque<>();
    
    // Push element x onto stack.
    public void push(int x) {
        deque.addFirst(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (!empty()) {
            deque.poll();
        }
    }

    // Get the top element.
    public int top() {
        if (!empty()) {
            return deque.peek();
        }
        return 0;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return deque.isEmpty();
    }
}
