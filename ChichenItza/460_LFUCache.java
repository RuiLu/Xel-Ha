public class LFUCache {
    
    /**
     *  Idea -> class Node, each node represents a appearing frequency, doubled-linked with each other, and
     *                      has a LinkedHashSet to store keys in order.
     *          valueMap, HashMap for key/value pair.
     *          nodeMap, HashMap for key/node pair.
     * 
     *          Every time, one key is referenced: 
     *          1. Find the current node corresponding to the key; 
     *          2. If the following node exists and the frequency is larger by one, 
     *             add key to the keys of the following node;
     *          3. Else create a new node and add it following the current node;
     *          4. When adding a new node, if the size exceeds the capacity, we remove the key/value with least freqency;
     *          5. If head node with zero key, then we remove the head node.
     * 
     *  Time complexity -> O(1)f
     */
    
    class Node {
        int freq;
        LinkedHashSet<Integer> keys;
        Node prev;
        Node next;
        
        public Node(int freq) {
            this.freq = freq;
            this.keys = new LinkedHashSet<Integer>();
            this.prev = null;
            this.next = null;
        }
    }
    
    private int capacity;
    private Node head;
    private HashMap<Integer, Integer> valueMap;
    private HashMap<Integer, Node> nodeMap;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        head = null;
        valueMap = new HashMap<Integer, Integer>();
        nodeMap = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if (valueMap.containsKey(key)) {
            increaseFreq(key);
            return valueMap.get(key);
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if (capacity == 0) return;
        if (valueMap.containsKey(key)) {
            valueMap.put(key, value);
        } else {
            if (valueMap.size() < capacity) {
                valueMap.put(key, value);
            } else {
                deleteHead();
                valueMap.put(key, value);
            }
            addToHead(key);
        }
        increaseFreq(key);
    }
    
    private void addToHead(int key) {
        if (head == null) {
            head = new Node(0);
            head.keys.add(key);
        } else if (head.freq > 0) {
            Node node = new Node(0);
            node.keys.add(key);
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            head.keys.add(key);
        }
        nodeMap.put(key, head);
    }
    
    private void increaseFreq(int key) {
        Node node = nodeMap.get(key);
        node.keys.remove(key);
        
        if (node.next == null) {
            node.next = new Node(node.freq + 1);
            node.next.prev = node;
            node.next.keys.add(key);
        } else if (node.next.freq == node.freq + 1) {
            node.next.keys.add(key);
        } else {
            Node tmp = new Node(node.freq + 1);
            tmp.keys.add(key);
            tmp.prev = node;
            tmp.next = node.next;
            node.next.prev = tmp;
            node.next = tmp;
        }
        
        nodeMap.put(key, node.next);
        if (node.keys.size() == 0) remove(node);
    }
    
    private void deleteHead() {
        if (head == null) return;
        int oldKey = 0;
        for (int key : head.keys) {
            oldKey = key;
            break;
        }
        head.keys.remove(oldKey);
        if (head.keys.size() == 0) remove(head);
        valueMap.remove(oldKey);
        nodeMap.remove(oldKey);
    }
    
    private void remove(Node node) {
        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.set(key,value);
 */
