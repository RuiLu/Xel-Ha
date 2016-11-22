public class LRUCache {
    /**
     *  Create a double-linked list, easy to add to the head and delete
     *  Three helper functions -> for double-linked list
     *  1. add item to first
     *  2. delete any item on list
     *  3. move any item to list head
     */
    private class Item {
        int key = 0;
        int value = 0;
        Item prev = null;
        Item next = null;
        
        public Item() {}
        
        public Item(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private HashMap<Integer, Item> itemMap = null;
    private int count = 0;
    private int capacity = 0;
    private Item fakeHead = null;
    private Item fakeTail = null;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        itemMap = new HashMap<>();
        
        fakeHead = new Item();
        fakeTail = new Item();
        
        fakeHead.next = fakeTail;
        fakeTail.prev = fakeHead;
    }
    
    public int get(int key) {
        Item item = itemMap.get(key);
        if (item == null) return -1;
        else moveToHead(item);
        return item.value;
    }
    
    public void set(int key, int value) {
        Item item = itemMap.get(key);
        if (item != null) {
            item.value = value;
            moveToHead(item);
        } else {
            Item newItem = new Item(key, value);
            itemMap.put(key, newItem);
            addItem(newItem);
            count++;
            if (count > capacity) {
                itemMap.remove(fakeTail.prev.key);
                deleteItem(fakeTail.prev);
                count--;
            }
        }
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
    
    private void moveToHead(Item item) {
        deleteItem(item);
        addItem(item);
    }
}
