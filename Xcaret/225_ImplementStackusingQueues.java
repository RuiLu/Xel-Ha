class MyStack {
    /**
     *  Idea -> Using Deque
     */
    private Deque<Integer> queue = new ArrayDeque<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        queue.addFirst(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (!queue.isEmpty()) queue.poll();
    }

    // Get the top element.
    public int top() {
        if (!queue.isEmpty()) return queue.peek();
        return 0;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
