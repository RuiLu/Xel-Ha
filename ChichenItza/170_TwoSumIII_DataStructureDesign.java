public class TwoSum {
    /**
     *  Suitable for lots of add operations, and few find operations.
     *  Time complexity -> O(1) for add(). O(n) for find().
     */
    private HashMap<Integer, Integer> map = new HashMap<>();

    // Add the number to an internal data structure.
	public void add(int number) {
	    map.put(number, map.getOrDefault(number, 0)+1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (int num1 : map.keySet()) {
	        int num2 = value-num1;
	        if (!map.containsKey(num2)) continue;
	        
	        if (num1 != num2) {
	            return true;
	        } else {
	            if (map.get(num1) >= 2) return true;
	            else continue;
	        }
	    }
	    return false;
	}
    
    /**
     * Suitable for lots of find operations, and few add operations.
     * Time complexity -> O(1) for find(). O(n) for add().
     */
    private HashSet<Integer> sumSet;
    private HashSet<Integer> numSet;
    
    public TwoSum() {
        sumSet = new HashSet<>();
        numSet = new HashSet<>();
    }
    
    public void add(int number) {
        if (numSet.contains(number)) {  // already contains number
            sumSet.add(number*2);       // add double value of number into sumSet
        } else {
            Iterator<Integer> ii = numSet.iterator();
            while (ii.hasNext()) {
                sumSet.add(ii.next()+number);   // add all new pairs sum into sumSet
            }
            numSet.add(number);
        }
    }
    
    public boolean find(int value) {
        return sumSet.contains(value);
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
