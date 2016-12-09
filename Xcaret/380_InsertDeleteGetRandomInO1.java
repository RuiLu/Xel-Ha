public class RandomizedSet {
    /**
     *  Idea -> The key to this problem is that ArrayList's remove(Object obj) function takes O(1) time.
     *          And there is not space complexity limitation
     */
    private ArrayList<String> list;
    private HashSet<Integer> set;
    private Random rand;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<String>();
        set = new HashSet<Integer>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!set.add(val)) return false;
        list.add(Integer.toString(val));
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!set.remove(val)) return false;
        list.remove(Integer.toString(val));
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int r = rand.nextInt(list.size());
        return Integer.parseInt(list.get(r));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
