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
     *  Time complexity -> O(1)
     */

    private class Node {
        LinkedHashSet<Integer> keys;
        int freq;
        Node next;
        Node prev;
        
        public Node(int freq) {
            this.freq = freq;
            keys = new LinkedHashSet<>();
            next = null;
            prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int capacity;
    private HashMap<Integer, Node> nodeMap;
    private HashMap<Integer, Integer> valueMap;

    /**
     * Add a new Node before a given node. The frequency of new Node is the freqency of node + 1.
     * 
     * @newNode - new Node for insertion 
     * @node    - original Node after the new Node
     */
    private void addBefore(Node newNode, Node node) {
        newNode.next = node;
        newNode.prev = node.prev;
        
        node.prev.next = newNode;
        node.prev = newNode;
    }
    
    /**
     * Delete a node in double-linked list
     */
    private void delete(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * Increase the frequency of given key.
     */
    private void increaseFreq(int key) {
        Node oldNode = nodeMap.get(key);
        Node newNode = null;
        
        /* Assume the previous frequency is k, 
         * If there is no node with frequency k+1, add a new one.
         * Otherwise, get node with frequency k+1 */
        if (oldNode.prev.freq != oldNode.freq+1) {
            newNode = new Node(oldNode.freq+1);
            addBefore(newNode, oldNode);
        } else {
            newNode = oldNode.prev;
        }
        
        newNode.keys.add(key);
        nodeMap.put(key, newNode);
        
        /* Remove key from oldNode. If oldNode contains no keys, delete oldNode. */
        oldNode.keys.remove(key);
        if (oldNode.keys.size() == 0) delete(oldNode);
    }

    /**
     * Remove the key with least frequency.
     */
    private void removeLastKey() {
        /* Get the last node. */
        Node node = tail.prev;
        
        int oldKey = 0;
        for (int key : node.keys) {
            oldKey = key;
            break;
        }
        
        node.keys.remove(oldKey);
        nodeMap.remove(oldKey);
        valueMap.remove(oldKey);
        if (node.keys.size() == 0) delete(node);
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        valueMap = new HashMap<>();
        
        head = new Node(-1);
        tail = new Node(-1);
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        /* If key already exists, update its frequency. */
        if (valueMap.containsKey(key)) {
            increaseFreq(key);
            return valueMap.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        
        /* If key already exists, update its frequency. */
        if (valueMap.containsKey(key)) {
            valueMap.put(key, value);
            increaseFreq(key);
        } else {
            /* If current size is equal to capacity, meaning that adding one key will cause overflow. 
             * So remove the key with least frequency first. */
            if (valueMap.size() >= capacity) {
                removeLastKey();
            }
            
            valueMap.put(key, value);
            Node node = null;
            
            if (tail.prev.freq == 1) {
                node = tail.prev;
            } else {
                node = new Node(1);
                addBefore(node, tail);
            }
            node.keys.add(key);
            nodeMap.put(key, node);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
