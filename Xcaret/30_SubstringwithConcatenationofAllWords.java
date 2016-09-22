public class Solution {
    /**
     *  1. There are wordLen times traversa -> O(wl)
     *  2. In each traverse, takes O(n/wl) times
     *  3. In each traverse, the most time that a word is accesses is two -> O(2)
     *  4. Total time complexity -> O(wl * n/wl * 2) ~ O(2n) ~ O(n)
     * 
     *  Reference -> https://discuss.leetcode.com/topic/6617/an-o-n-solution-with-detailed-explanation
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        
        int len = words.length;
        int wordLen = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        
        for (String word : words) {
            if (!map.containsKey(word)) map.put(word, 0);
            map.put(word, map.get(word) + 1);
        }
        
        for (int i = 0; i < wordLen; i++) {
            int start = i;
            int count = 0;
            Map<String, Integer> tmp = new HashMap<>();
            
            for (int j = i; j + wordLen <= s.length(); j += wordLen) {
                String next = s.substring(j, j + wordLen);
                
                if (map.containsKey(next)) {
                    if (!tmp.containsKey(next)) tmp.put(next, 0);
                    tmp.put(next, tmp.get(next) + 1);
                    
                    if (tmp.get(next) <= map.get(next)) {
                        count++;
                    } else {
                        while (tmp.get(next) > map.get(next)) {
                            String prev = s.substring(start, start + wordLen);
                            tmp.put(prev, tmp.get(prev) - 1);
                            if (tmp.get(prev) < map.get(prev)) count--;
                            start += wordLen;
                        }
                    }
                    
                    if (count == len) {
                        String prev = s.substring(start, start + wordLen);
                        tmp.put(prev, tmp.get(prev) - 1);
                        count--;
                        res.add(start);
                        start += wordLen;
                        
                    }
                } else {
                    count = 0;
                    start = j + wordLen;
                    tmp.clear();
                }
            }
        }
        
        return res;
    }
}
