public class LRUCache {
    
    /**
     * Self-defined data structure for double-linked list
     */
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        public Node() {
            key = 0;
            value = 0;
            prev = null;
            next = null;
        }
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }
    
    private Map<Integer, Node> nodeMap;
    private Node fakeHead;
    private Node fakeTail;
    private int capacity;
    private int count;
    
    /**
     * Add a new Node to the head of list
     */
    private void addNode(Node node) {
        node.prev = fakeHead;
        node.next = fakeHead.next;
        
        fakeHead.next.prev = node;
        fakeHead.next = node;
    }
    
    /**
     * Delete a Node from the list
     */
    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    /**
     * When update a Node, move it to the head of list
     */
    private void moveToHead(Node node) {
        deleteNode(node);
        addNode(node);
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        nodeMap = new HashMap<>();
        
        fakeHead = new Node();
        fakeTail = new Node();
        
        fakeHead.next = fakeTail;
        fakeTail.prev = fakeHead;
    }
    
    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        Node node = nodeMap.get(key);
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        
        Node node = null;
        if (nodeMap.containsKey(key)) {
            node = nodeMap.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            node = new Node(key, value);
            addNode(node);
            count++;
            
            if (count > capacity) {
                /* remove the last node */
                Node removedNode = fakeTail.prev;
                nodeMap.remove(removedNode.key);
                deleteNode(removedNode);
            }
        }
        
        nodeMap.put(key, node);
    }
    
}
