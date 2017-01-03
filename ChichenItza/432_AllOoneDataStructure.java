public class AllOne {
    /**
     *  Idea -> Using HashMap and Doubled-linked List to implement this data structure.
     *          Each node on the Doubled-linked List contains its value, a key list, and two pointers.
     *          I create two helper nodes, head and tail, to build this data structure.
     *          Nodes near head are with bigger values, and nodes near tail are with smaller values.
     *          Update all the time.
     *          See comments for details.
     *  Time complexity -> O(1) for all operations.
     */
     
    class Node {
        int val;
        ArrayList<String> list;
        Node prev;
        Node next;
        
        public Node(int val) {
            this.val = val;
            list = new ArrayList<>();
            prev = null;
            next = null;
        }
    }
    
    private HashMap<String, Integer> lookup;    // map for looking up key/value pair
    private HashMap<Integer, Node> store;       // map for looking up value/node pair
    private Node head;
    private Node tail;
    
    /** Initialize your data structure here. */
    public AllOne() {
        lookup = new HashMap<>();
        store = new HashMap<>();
        head = new Node(-1);
        tail = new Node(-1);
        
        head.next = tail;
        tail.prev = head;
    }
    
    /*
     *  Add new node before an old node.
     */
    private void addBefore(Node newNode, Node oldNode) {
        newNode.next = oldNode;
        newNode.prev = oldNode.prev;
        
        oldNode.prev.next = newNode;
        oldNode.prev = newNode;
    }
    /*
     *  Add new node after an old node.
     */    
    private void addAfter(Node newNode, Node oldNode) {
        newNode.prev = oldNode;
        newNode.next = oldNode.next;
        
        oldNode.next.prev = newNode;
        oldNode.next = newNode;
    }
    /*
     *  Remove a node.
     */    
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (!lookup.containsKey(key)) {    // if the insert key is a new key
             lookup.put(key, 1);
             // If there is no node storing value 1, then we add a new node into the data structure.
             // Otherwise, simply add the new key into the corresponding node.
             if (!store.containsKey(1)) {
                 Node node = new Node(1);
                 node.list.add(key);
                 store.put(1, node);
                 addBefore(node, tail);
             } else {
                 store.get(1).list.add(key);
             }
         } else {                           // if the key has existed in the data structure
             int val = lookup.get(key) + 1;
             lookup.put(key, val);
             
             Node oldNode = store.get(val-1);
             oldNode.list.remove(key);
             
             // If there is no node storing value 1, then we add a new node into the data structure.
             // Otherwise, simply add the new key into the corresponding node.
             if (!store.containsKey(val)) {
                 Node newNode = new Node(val);
                 newNode.list.add(key);
                 store.put(val, newNode);
                 addBefore(newNode, oldNode);
             } else {
                 Node node = store.get(val);
                 node.list.add(key);
             }
             
             // In this case, we need to determine whether the old node is empty.
             // If so, we should remove the old node.
             if (oldNode.list.size() == 0) {
                 remove(oldNode);
                 store.remove(val-1);
             }
         }
         
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!lookup.containsKey(key)) return;
        
        int val = lookup.get(key) - 1;
        
        Node oldNode = store.get(val+1);
        oldNode.list.remove(key);
        
        // If the new value is bigger than 0, then we should insert the key into the node with value (oldValue - 1).
        // Otherwise, which is the new value is 0, then we simply remove the key from lookup map.
        if (val > 0) {
            lookup.put(key, val);
            
            // We should check whether there is a node with new value in the data structure
            if (!store.containsKey(val)) {
                Node newNode = new Node(val);
                newNode.list.add(key);
                store.put(val, newNode);
                addAfter(newNode, oldNode);
            } else {
                Node node = store.get(val);
                node.list.add(key);
            }
        } else if (val == 0) {
            lookup.remove(key);
        }
        
        if (oldNode.list.size() == 0) {
            remove(oldNode);
            store.remove(val+1);
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (head.next == tail) return "";
        return head.next.list.get(0);
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (tail.prev == head) return "";
        return tail.prev.list.get(0);
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
