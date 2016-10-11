public class Solution {
    /**
     *  Using a Map to check whether a substring appears more than once
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        if (s == null || s.length() <= 10) return list;
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 10; i <= s.length(); i++) {
            String str = s.substring(i - 10, i);
            
            if (map.containsKey(str)) {
                if (map.get(str) == 1) list.add(str);
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        
        return list;
    }
    
    /**
     *  Or using two sets
     *  Reference -> https://discuss.leetcode.com/topic/27517/7-lines-simple-java-o-n
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        
        for (int i = 0; i + 9 < s.length(); i++) {
            String str = s.substring(i, i + 10);
            
            // if str has already in seen, seen.add(str) will return false 
            if (!seen.add(str)) {
                repeated.add(str);
            }
        }
        
        return new ArrayList<>(repeated);
    }
}
