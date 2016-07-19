public class LRUCache {
    
    /* 
    HashMap -> store key/value pair
    Doubld linked-list -> easy to delete and add node from head or tail  
    */ 
    
    private Map<Integer, Item> itemMap;
    private int capacity;
    private int count;
    private Item fakeHead, fakeTail;
    
    private class Item {
        int key;
        int value;
        Item prev;
        Item next;
    }
    
    private void addItem(Item item) {
        item.prev = fakeHead;
        item.next = fakeHead.next;
        
        fakeHead.next.prev = item;
        fakeHead.next = item;
    }
    
    private void removeItem(Item item) {
        item.prev.next = item.next;
        item.next.prev = item.prev;
    }
    
    private void moveToHead(Item item) {
        this.removeItem(item);
        this.addItem(item);
    }
    
    public LRUCache(int capacity) {
        itemMap = new HashMap<Integer, Item>();
        this.capacity = capacity;
        this.count = 0;
        
        fakeHead = new Item();
        fakeHead.prev = null;
        
        fakeTail = new Item();
        fakeTail.next = null;
        
        fakeHead.next = fakeTail;
        fakeTail.prev = fakeHead;
    }
    
    public int get(int key) {
        
        Item item = itemMap.get(key);
        
        if (item == null) {
            return -1;
        } else {
            this.moveToHead(item);
        }
        
        return item.value;
        
    }
    
    public void set(int key, int value) {
        
        Item item = itemMap.get(key);
        
        if (item == null) {
            Item newItem = new Item();
            newItem.key = key;
            newItem.value = value;
            
            itemMap.put(key, newItem);
            this.addItem(newItem);
            count++;
            
            if (count > capacity) {
                Item tail = fakeTail.prev;
                this.removeItem(tail);
                itemMap.remove(tail.key);
                count--;
            }
        } else {
            item.value = value;
            this.moveToHead(item);
        }
        
    }
}
    
