public class LRUCache {
    /**
     *  Idea -> Maintain a double-linked list
     *  Time complexity -> O(1)
     */
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        
        public Node() {
            prev = null;
            next = null;
        }
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    } 
    
    private int capacity;
    private int count;
    private HashMap<Integer, Node> nodeMap;
    private Node fakeHead;
    private Node fakeTail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        count = 0;
        
        fakeHead = new Node();
        fakeTail = new Node();
        
        fakeHead.next = fakeTail;
        fakeTail.prev = fakeHead;
    }
    
    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        Node node = nodeMap.get(key);
        moveToHead(node);
        return node.val;
    }
    
    public void set(int key, int value) {
        Node node = nodeMap.get(key);
        if (node != null) {
            node.val = value;
            nodeMap.put(key, node);
            moveToHead(node);
        } else {
            count++;
            Node newNode = new Node(key, value);
            nodeMap.put(key, newNode);
            addNode(newNode);
            
            if (count > capacity) {
                Node deleteNode = fakeTail.prev;
                deleteNode(deleteNode);
                nodeMap.remove(deleteNode.key);
                count--;
            }
            
        }
    }
    
    private void addNode(Node node) {
        node.prev = fakeHead;
        node.next = fakeHead.next;
        
        fakeHead.next.prev = node;
        fakeHead.next = node;
    }
    
    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void moveToHead(Node node) {
        deleteNode(node);
        addNode(node);
    }
}
