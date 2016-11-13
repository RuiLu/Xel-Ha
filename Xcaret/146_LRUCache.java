public class LRUCache {
    /**
     *  Create a double-linked list, easy to add to the head and delete
     *  Three helper functions -> for double-linked list
     *  1. add item to first
     *  2. delete any item on list
     *  3. move any item to list head
     */
    private Map<Integer, Item> map = null;
    private int count = 0;
    private int capacity = 0;
    private Item fakeHead = null;
    private Item fakeTail = null;
    
    private class Item {
        int key = 0;
        int val = 0;
        Item next = null;
        Item prev = null;
        
        public Item() {}
        
        public Item(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    private void moveToHead(Item item) {
        deleteItem(item);
        addItem(item);
    }
    
    private void deleteItem(Item item) {
        item.prev.next = item.next;
        item.next.prev = item.prev;
    }
    
    private void addItem(Item item) {
        item.prev = fakeHead;
        item.next = fakeHead.next;
        
        fakeHead.next.prev = item;
        fakeHead.next = item;
    }
    
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        
        fakeHead = new Item();
        fakeTail = new Item();
        
        fakeHead.next = fakeTail;
        fakeTail.prev = fakeHead;
    }
    
    public int get(int key) {
        Item item = map.get(key);
        if (item == null) return -1;
        else moveToHead(item);
        return item.val;
    }
    
    public void set(int key, int value) {
        Item item = map.get(key);
        if (item != null) {
            item.val = value;
            moveToHead(item);
        } else {
            Item newItem = new Item(key, value);
            addItem(newItem);
            map.put(key, newItem);
            count++;
            
            if (count > capacity) {
                map.remove(fakeTail.prev.key);
                deleteItem(fakeTail.prev);
                count--;
            }
        }
    }
}
