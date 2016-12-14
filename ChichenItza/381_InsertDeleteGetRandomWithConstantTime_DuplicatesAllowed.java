public class RandomizedCollection {

    /**
     *  Basically the same idea as one without duplicates,
     *  Just use a set to record the positions of duplicates
     *  Reference -> https://discuss.leetcode.com/topic/53216/java-solution-using-a-hashmap-and-an-arraylist-along-with-a-follow-up-131-ms/5
     */
    private ArrayList<Integer> list;
    private HashMap<Integer, HashSet<Integer>> map;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, HashSet<Integer>>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = map.containsKey(val);
        if (!contains) map.put(val, new HashSet<Integer>());
        map.get(val).add(list.size());
        list.add(val);
        return !contains;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        
        int pos = map.get(val).iterator().next();
        map.get(val).remove(pos);
        
        if (pos < list.size() - 1) {
            int lastOne = list.get(list.size() - 1);
            list.set(pos, lastOne);
            map.get(lastOne).remove(list.size() - 1);
            map.get(lastOne).add(pos);
        }
        
        list.remove(list.size() - 1);
        if (map.get(val).isEmpty()) map.remove(val);
        
        return true; 
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int r = rand.nextInt(list.size());
        return list.get(r);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
