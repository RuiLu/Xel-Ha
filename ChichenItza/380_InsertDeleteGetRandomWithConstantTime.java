public class RandomizedSet {

    private static HashSet<Integer> set;
    private static ArrayList<String> list;
    private static Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new HashSet<Integer>();
        list = new ArrayList<String>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!set.add(val)) return false;
        return list.add(Integer.toString(val));
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!set.remove(val)) return false;
        return list.remove(Integer.toString(val));
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
