public class Solution {
    /**
     *  Idea -> DFS + Backtracking, in order to save time, we can use a memorization map
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return new ArrayList<String>();
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        return wordBreakHelper(s, wordDict, map);
    }
    
    private List<String> wordBreakHelper(String s, Set<String> wordDict, Map<String, ArrayList<String>> map) {
        ArrayList<String> res = new ArrayList<String>();
        
        /* 1. determin current status */
        if (s.equals("")) {
            res.add(s);
            return res;
        }
        
        if (map.containsKey(s)) return map.get(s);
        
        /* 2. go over all words in wordDict to see whether there is a match for current String */
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> nextList = wordBreakHelper(s.substring(word.length()), wordDict, map);
                for (String next : nextList) {
                    res.add(word + (next.equals("") ? "" : " " + next));
                }
            }
        }
        
        /* 3. put result into map, used for memorization */
        map.put(s, res);
        return res;
    }
}
