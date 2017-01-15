public class LRUCache {
    /**
     *  Idea -> Maintain a double-linked list
     *  Time complexity -> O(1)
     */
    private class Node {
        int key;
        Node prev;
        Node next;
        
        public Node() {
            prev = null;
            next = null;
        }
        
        public Node(int key) {
            this.key = key;
            prev = null;
            next = null;
        }
    }
    
    private HashMap<Integer, Integer> valueMap;
    private HashMap<Integer, Node> nodeMap;
    private Node head;
    private Node tail;
    private int capacity;
    
    /**
     * Move the given node to head. First remove node then add it to the head.
     */
    private void moveNodeToHead(Node node) {
        removeNode(node);
        addNode(node);
    }
    
    /**
     * Add the given node to head.
     */
    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;
        
        head.next.prev = node;
        head.next = node;
    }
    
    /**
     * Remove the given node from double-linked list.
     */
    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        valueMap = new HashMap<>();
        nodeMap = new HashMap<>();
        
        head = new Node();
        tail = new Node();
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (valueMap.containsKey(key)) {
            moveNodeToHead(nodeMap.get(key));
            return valueMap.get(key);
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if (capacity <= 0) return;
        
        Node node = null;
        if (valueMap.containsKey(key)) {
            node = nodeMap.get(key);
            moveNodeToHead(node);
        } else {
            if (valueMap.size() >= capacity) {
                Node deleteNode = tail.prev;
                int deleteKey = deleteNode.key;
                valueMap.remove(deleteKey);
                nodeMap.remove(deleteKey);
                removeNode(deleteNode);
            }
            
            node = new Node(key);
            nodeMap.put(key, node);
            addNode(node);
            
        }
        
        valueMap.put(key, value);
    }
    
}
