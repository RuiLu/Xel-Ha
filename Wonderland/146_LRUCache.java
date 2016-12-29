public class LRUCache {
    
    /**
     * 1. HashMap -> store key/value pair  
     * 2. Doubled LinkedList -> easy to add and delete node from head and tail
     */
    
    private HashMap<Integer, Item> itemMap;
    private int capacity;
    private int count;
    private Item fakeHead, fakeTail;
    
    private class Item {
        int key;
        int value;
        Item next, prev;
        
        public Item() {}
        
        public Item(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    /**
     *  Three helper functions -> for double-linked list
     *  1. add item to first
     *  2. delete any item on list
     *  3. move any item to list head
     */
    private void addItem(Item item) {
        item.prev = fakeHead;
        item.next = fakeHead.next;
        
        fakeHead.next.prev = item;
        fakeHead.next = item;
    }
    
    private void deleteItem(Item item) {
        item.prev.next = item.next;
        item.next.prev = item.prev;
    }
    
    private void moveToHead(Item item) {
        this.deleteItem(item);
        this.addItem(item);
    }
    
    public LRUCache(int capacity) {
        itemMap = new HashMap<Integer, Item>();
        this.capacity = capacity;
        this.count = 0;
        
        fakeHead = new Item();
        fakeTail = new Item();
        
        fakeHead.prev = null;
        fakeHead.next = fakeTail;
        
        fakeTail.next = null;
        fakeTail.prev = fakeHead;
    }
    
    public int get(int key) {
        Item item = itemMap.get(key);
        
        if (item == null) return -1;
        else this.moveToHead(item);
        
        return item.value;
    }
    
    public void set(int key, int value) {
        Item item = itemMap.get(key);
        
        if (item == null) {
            Item newItem = new Item(key, value);
            this.addItem(newItem);
            itemMap.put(key, newItem);
            count++;
            
            if (count > capacity) {
                Item deleteItem = fakeTail.prev;
                this.deleteItem(deleteItem);
                itemMap.remove(deleteItem.key);
                count--;
            }
        } else {
            item.value = value;
            this.moveToHead(item);
        }
    }
}
    
