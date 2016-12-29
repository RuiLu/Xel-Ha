/**
 *  1. Naive -> Using a queue and a set
 */
public class PhoneDirectory {

     private Set<Integer> set;
     private Queue<Integer> queue;
     private int capacity;
    
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        set = new HashSet<>();
        queue = new LinkedList<>();
        capacity = maxNumbers;
        
        for (int i = 0; i < capacity; i++) queue.offer(i);
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (queue.isEmpty()) return -1;
        int num = queue.poll();
        set.add(num);
        return num;
    }
        
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number >= capacity || number < 0) return false;
        return !set.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (set.contains(number)) {
            set.remove(number);
            queue.offer(number);
        }
    }
}

/**
 *  2. Extend BitSet. Such a brilliant idea!!
 *  Reference -> https://discuss.leetcode.com/topic/53120/subclassing-set-python-java
 *  API reference -> https://docs.oracle.com/javase/7/docs/api/java/util/BitSet.html
 */ 
public class PhoneDirectory extends BitSet {
    
    public PhoneDirectory(int maxNumbers) {
        super(maxNumbers);
        flip(0, maxNumbers);
    }
    
    public int get() {
        if (isEmpty()) return -1;
        
        int number = nextSetBit(0);
        clear(number);
        return number;
    }
    
    public boolean check(int number) {
        return get(number);
    }
    
    public void release(int number) {
        set(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
