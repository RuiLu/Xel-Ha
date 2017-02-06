public class RandomizedSet {
    /**
     * Idea -> Use a HashMap, key is value, value is its position in ArrayList
     *         When removing a value, if this value is the last one in ArrayList, do it directly;
     *         Otherwise, swap this value with the value located on the last position of ArrayList.
     *         Finally, remove the last value.
     * 
     * Follow-up -> Allow duplicate, we can modify Map<Integer, Integer> to Map<Integer, Set<Integer>>.
     *              https://discuss.leetcode.com/topic/53216/java-solution-using-a-hashmap-and-an-arraylist-along-with-a-follow-up-131-ms/4
     */
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random rand;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if (contain) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean contain = map.containsKey(val);
        if (!contain) return false;
        
        /* find the index of val */
        int idx = map.get(val);
        if (idx < list.size()-1) {
            int lastVal = list.get(list.size()-1);
            list.set(idx, lastVal);
            map.put(lastVal, idx);
        }
        list.remove(list.size()-1);
        map.remove(val);
        
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

    /**
     * Idea -> Convert Integer to String, because ArrayList.remove(String) takes O(1) time
     */
    // private static HashSet<Integer> set;
    // private static ArrayList<String> list;
    // private static Random rand;

    // /** Initialize your data structure here. */
    // public RandomizedSet() {
    //     set = new HashSet<Integer>();
    //     list = new ArrayList<String>();
    //     rand = new Random();
    // }
    
    // /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    // public boolean insert(int val) {
    //     if (!set.add(val)) return false;
    //     return list.add(Integer.toString(val));
    // }
    
    // /** Removes a value from the set. Returns true if the set contained the specified element. */
    // public boolean remove(int val) {
    //     if (!set.remove(val)) return false;
    //     return list.remove(Integer.toString(val));
    // }
    
    // /** Get a random element from the set. */
    // public int getRandom() {
    //     int r = rand.nextInt(list.size());
    //     return Integer.parseInt(list.get(r));
    // }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
