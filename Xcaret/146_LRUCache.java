public class LRUCache {
    /**
     *  Create a double-linked list, easy to add to the head and delete
     *  Three helper functions -> for double-linked list
     *  1. add item to first
     *  2. delete any item on list
     *  3. move any item to list head
     */
    private int capacity = 0;
    private int count = 0;
    private Map<Integer, Item> map = null;
    private Item fakeHead = null;
    private Item fakeTail = null;
    
    class Item {
        int key = 0;
        int value = 0;
        Item next = null;
        Item prev = null;
        
        public Item() {}
        
        public Item(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    // first helper function
    private void moveItemToHead(Item item) {
        deleteItem(item);
        addItem(item);
    }
    
    // second helper function
    private void deleteItem(Item item) {
        item.next.prev = item.prev;
        item.prev.next = item.next;
    }
    
    // third helper function
    private void addItem(Item item) {
        item.prev = fakeHead;
        item.next = fakeHead.next;
        
        fakeHead.next.prev = item;
        fakeHead.next = item;
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.map = new HashMap<>();
        
        fakeHead = new Item();
        fakeTail = new Item();
        
        fakeHead.next = fakeTail;
        fakeTail.prev = fakeHead;
    }
    
    public int get(int key) {
        Item item = map.get(key);
        
        if (item == null) return -1;
        else moveItemToHead(item);
        
        return item.value;
    }
    
    public void set(int key, int value) {
        Item item = map.get(key);
        
        if (item != null) {
            item.value = value;
            moveItemToHead(item);
        } else {
            item = new Item(key, value);
            map.put(key, item);
            addItem(item);
            count++;
            
            if (count > capacity) {
                map.remove(fakeTail.prev.key);
                deleteItem(fakeTail.prev);
                count--;
            }
        }
    }
}
