/**
 * Implement a inner class - Node, a node stores three parameters: 1.val; 2.min; 3.next,
 * from which min is the minimum value from current node to the tail node
 */ 
class MinStack {
    
    private Node head = null;
    
    public void push(int x) {
         if (head == null) {
             head = new Node(x, x, null);
         } else {
             head = new Node(x, Math.min(x, head.min), head);
         }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
    
    class Node {
        int val;
        int min;
        Node next;
        
        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    
}
