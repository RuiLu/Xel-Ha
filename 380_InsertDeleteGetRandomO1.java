public class RandomizedSet {
    /**
     *  Reference -> https://discuss.leetcode.com/topic/53216/java-solution-using-a-hashmap-and-an-arraylist-along-with-a-follow-up-131-ms
     */
    
    private List<Integer> nums;
    private Map<Integer, Integer> map;  // key -> number, value -> its location
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        
        map.put(val, nums.size());
        nums.add(val);
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int loc = map.get(val);
        if (loc != nums.size() - 1) {
            int lastOne = nums.get(nums.size() - 1);
            nums.set(loc, lastOne);
            map.put(lastOne, loc);
        }
        
        map.remove(val);
        nums.remove(nums.size() - 1);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
