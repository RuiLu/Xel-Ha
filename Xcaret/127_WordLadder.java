public class Solution {
    /**
     *  The idea is like BFS, with two sets to approach each other
     *  Time complexity -> really hard to say -> O(w * n)
     *                                        -> traverse alphabet takes O(26w), where w is word length
     *                                        -> we access words from wordlist only once, taking O(n) time
     *                                        -> in total, O(w * n)
     */
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (wordList.size() == 0) return 0;
        
        // we should initialize minLen to 1, because has started with beginWord
        int minLen = 1;
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> visited = new HashSet<>();  // avoid duplicates
        
        begin.add(beginWord);
        end.add(endWord);
        
        // idea is similar with BFS
        while (!begin.isEmpty() && !end.isEmpty()) {
            if (begin.size() > end.size()) {
                Set<String> tmp = new HashSet<>();
                tmp = begin;
                begin = end;
                end = tmp;
            }
            
            // tmp is created for next step
            Set<String> tmp = new HashSet<>();
            for (String str : begin) {
                char[] sca = str.toCharArray();
                // we try all possibilities one by one
                for (int i = 0; i < sca.length; i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char old = sca[i];
                        sca[i] = ch;
                        String next = new String(sca);
                        
                        if (end.contains(next)) return minLen + 1;
                        
                        if (wordList.contains(next) && !visited.contains(next)) {
                            tmp.add(next);
                            visited.add(next);
                        }
                        
                        sca[i] = old;
                    } 
                }
            }
            
            begin = tmp;
            minLen++;
        }
        
        return 0;
    }
}
