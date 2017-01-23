public class Solution {
    /**
     * Idea -> Compute an ID for each kind of anagrams, then maintain a HashMap to store them.
     * Time complexity -> O(nk), where n is the length of strs, k is the average length of string in strs.
     * Space complexity -> O(n)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        
        Map<Integer, List<String>> map = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            char[] ca = strs[i].toCharArray();
            int[] count = new int[26];
            /* all characters in string are lowercase characters */
            for (char ch : ca) count[ch-'a']++;
            
            /* compute ID, using hash value */
            int id = Arrays.hashCode(count);
            
            if (!map.containsKey(id)) map.put(id, new ArrayList<>());
            map.get(id).add(strs[i]);
        }
        
        for (int key : map.keySet()) res.add(map.get(key));
        
        return res;
    }
}
