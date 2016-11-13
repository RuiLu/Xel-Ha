class MyStack {
    /**
     *  Idea -> Using two Queues
     */
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();
    
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }
    
    public int pop() {
        return queue1.poll();
    }
    
    public int top() {
        return queue1.peek();
    }
     
    public boolean empty() {
        return queue1.isEmpty();
    }
    
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
