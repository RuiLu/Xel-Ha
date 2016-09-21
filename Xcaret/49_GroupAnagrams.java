public class Solution {
    /**
     *  Let's assume the longest length of string in strs is k, and the length of strs array is n
     *  So we can get time complexity is O(nklogk)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String key = String.valueOf(tmp);
            
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        
        return res;
    }
    
    /**
     *  We don't need to convert string to char array and sort the char array to get key now.
     *  We can use Arrays.hashCode() to create a key
     *  So the time complexity now is O(nk)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        
        Map<Integer, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            int id = getStringID(str);
            if (!map.containsKey(id)) map.put(id, new ArrayList<>());
            map.get(id).add(str);
        }
        
        for (int key : map.keySet()) res.add(map.get(key));
        
        return res;
    }
    
    private int getStringID(String str) {
        int[] count = new int[26];
        for (char ch : str.toCharArray()) {
            count[ch - 'a']++;
        }
        return Arrays.hashCode(count);
    }
}
