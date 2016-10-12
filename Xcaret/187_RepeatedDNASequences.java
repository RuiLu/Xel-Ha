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
        
        for (int i = 0; i + 9 < s.length(); i++) {
            String sub = s.substring(i, i + 10);
            if (map.containsKey(sub)) {
                if (map.get(sub) == 1)list.add(sub);
                map.put(sub, map.get(sub) + 1);
            } else {
                map.put(sub, 1);
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
        if (s == null || s.length() <= 10) return new ArrayList<>();;
        
        Set<String> seen = new HashSet<>();
        Set<String> duplicate = new HashSet<>();
        
        for (int i = 0; i + 9 < s.length(); i++) {
            String sub = s.substring(i, i + 10);
            if (!seen.add(sub)) {
                duplicate.add(sub);
            }
        }
        
        return new ArrayList<>(duplicate);
    }
}
