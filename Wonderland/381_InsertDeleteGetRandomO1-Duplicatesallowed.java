public class RandomizedCollection {

    /**
     *  Basically the same idea as one without duplicates,
     *  Just use a set to record the positions of duplicates
     *  Reference -> https://discuss.leetcode.com/topic/53216/java-solution-using-a-hashmap-and-an-arraylist-along-with-a-follow-up-131-ms/5
     */

    private List<Integer> nums;
    private Map<Integer, Set<Integer>> map;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = map.containsKey(val);
        if (!contains) map.put(val, new HashSet<>());
        
        map.get(val).add(nums.size());
        nums.add(val);
        
        return !contains;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        
        int pos = map.get(val).iterator().next();
        map.get(val).remove(pos);
        
        if (pos < nums.size() - 1) {
            int lastOne = nums.get(nums.size() - 1);
            nums.set(pos, lastOne);
            map.get(lastOne).remove(nums.size() - 1);
            map.get(lastOne).add(pos);
        }
        
        nums.remove(nums.size() - 1);
        if (map.get(val).isEmpty()) map.remove(val);
        
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
