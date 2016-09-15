public class TwoSum {
    /**
     *  First, like normal Two Sum solution
     *  Take too much time
     */
//     private List<Integer> nums = new ArrayList<>();
    
//     // Add the number to an internal data structure.
// 	public void add(int number) {
// 	    nums.add(number);
// 	}

//     // Find if there exists any pair of numbers which sum is equal to the value.
// 	public boolean find(int value) {
// 	    if (nums.size() <= 1) return false;
	    
// 	    Map<Integer, Integer> map = new HashMap<>();
	    
// 	    for (int num : nums) {
// 	        if (map.containsKey(num)) return true;
// 	        map.put(value - num, num);
// 	    }
	    
// 	    return false;
// 	}
	
	/**
	 *  Second, using two set, once adding a new number, update the num set and sum set
	 */
	private List<Integer> nums = new ArrayList<>();
	private Map<Integer, Integer> map = new HashMap<>();
	
	public void add(int number) {
	    if (map.containsKey(number)) map.put(number, map.get(number) + 1);
	    else {
	        map.put(number, 1);
	        nums.add(number);
	    }
	}
	
	public boolean find(int value) {
        for (int i = 0; i < nums.size(); i++) {
            int a = nums.get(i);
            int b = value - a;
            if ((a == b && map.get(a) > 1) || (a != b && map.containsKey(b))) return true;
	    }
	    
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
