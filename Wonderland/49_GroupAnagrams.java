public class Solution {
    /**
     *  In order to create key, convert string to sorted char array, then we can get key
     *  Time complexity -> O(n klogk), where k is the average length of string
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            
            String key = String.valueOf(ca);
            
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        
        for (String key : map.keySet()) res.add(map.get(key));
        
        return res;
    }
}
