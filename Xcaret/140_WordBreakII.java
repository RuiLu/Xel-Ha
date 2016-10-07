public class Solution {
    /**
     *  Backtracking based on memorized DFS (map)
     *  Time complexity -> O(len(wordDict) ^ len(s/minWordLen))
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> list = new ArrayList<>();
        if (s == null && wordDict.size() == 0) return list;
        Map<String, List<String>> map = new HashMap<>();
        return helper(s, wordDict, map);
    }
    
    private List<String> helper(String s, Set<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) return map.get(s);
        
        List<String> list = new ArrayList<>();
        
        if (s.equals("")) {
            list.add(s);
            return list;
        }
        
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> next = helper(s.substring(word.length()), wordDict, map);
                for (String str : next) {
                    list.add(word + (str.equals("") ? "" : " " + str));
                }
            }
        }
        
        map.put(s, list);
        return list;
    }
}
