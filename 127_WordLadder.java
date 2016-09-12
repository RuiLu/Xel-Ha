public class Solution {
    /**
     *  Using two sets, with the idea of BFS
     */
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int res = 1;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            /* Swap size to make sure the sizes of two sets are roughly the same */
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            
            Set<String> tmp = new HashSet<>();
            for (String str : beginSet) {
                char[] ca = str.toCharArray();
                for (int i = 0; i < ca.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char oldC = ca[i];
                        ca[i] = c;
                        String next = String.valueOf(ca);
                        
                        /* Build a connection between begin and end */
                        if (endSet.contains(next)) return res + 1;
                        
                        if (wordList.contains(next) && !visited.contains(next)) {
                            tmp.add(next);
                            visited.add(next);
                        }
                        
                        /* backtracking, return to original word */
                        ca[i] = oldC;
                    }
                }
            }
            
            res++;
            beginSet = tmp;
        }
        
        return 0;
    }
    
}
