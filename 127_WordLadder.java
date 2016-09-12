c class Solution {
    /**
     *  Using two sets, with the idea of BFS
     */
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (wordList.size() == 0) return 0;
        
        int len = 1;
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> visited = new HashSet<>();
        
        begin.add(beginWord);
        end.add(endWord);
        
        while (!begin.isEmpty() && !end.isEmpty()) {
            if (begin.size() > end.size()) {
                Set<String> tmp = begin;
                begin = end;
                end = tmp;
            }
            
            Set<String> tmp = new HashSet<>();
            for (String str : begin) {
                char[] ca = str.toCharArray();
                for (int i = 0; i < ca.length; i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char old = ca[i];
                        ca[i] = ch;
                        String next = String.valueOf(ca);
                        
                        if (end.contains(next)) return len + 1;
                        
                        if (wordList.contains(next) && !visited.contains(next)) {
                            tmp.add(next);
                            visited.add(next);
                        }
                        
                        ca[i] = old;    // backtracking
                    }
                }
            }
            
            begin = tmp;
            len++;
        }
        
        return 0;
    }
}
