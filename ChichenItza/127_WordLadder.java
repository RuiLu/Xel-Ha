public class Solution {
    /**
     *  Idea -> Bi-directed BFS
     *  Time complexity -> O(w*n) -> Access each word in wordList once, O(n)
     *                            -> For each word, check all possibilities for each character, O(26w),
     *                               where w is the length of word.
     */
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (wordList == null || wordList.size() == 0 || beginWord == null || endWord == null) {
            return 0;
        }
        
        int minLen = 1;
        HashSet<String> beginSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        /* Either of sets being empty means that the connection is broken. */
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            /* Maintain bi-direction */
            if (beginSet.size() > endSet.size()) {
                HashSet<String> helper = new HashSet<>();
                helper = beginSet;
                beginSet = endSet;
                endSet = helper;
            }
            
            /* The "new"/"next" beginSet of endSet */
            HashSet<String> tmp = new HashSet<>();
            for (String word : beginSet) {
                char[] wa = word.toCharArray();
                /* Change the original word character by character */
                for (int i = 0; i < wa.length; i++) {
                    char old = wa[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        wa[i] = ch;
                        String next = new String(wa);
                        
                        /* Find next word in opposite set, meaning two sets are connected */
                        if (endSet.contains(next)) return minLen+1;
                        
                        if (wordList.contains(next) && !visited.contains(next)) {
                            tmp.add(next);
                            visited.add(next);
                        }
                        
                        /* Reset */
                        wa[i] = old;
                    }
                }
            }
            
            /* Move one step forward */
            minLen++;
            beginSet = tmp;
        }
        
        return 0;
    }
    
    /**
     *  Idea -> Dijkstra's algorithm
     *  Trick -> We can use Queue to avoid duplicate
     *  Time complexity -> O(n*w)
     */ 
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (wordList == null || wordList.size() == 0 || beginWord == null || endWord == null) {
            return 0;
        }
        
        int distance = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        wordList.add(endWord);
        wordList.remove(beginWord);
        
        /* Queue being not empty means that there still exists some connections. */
        while (!queue.isEmpty()) {
            int size = queue.size();
            /* Find all neighbors for words in current distance */
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) return distance;
                List<String> neighbors = getNeighbors(curr, wordList);
                for (String neighbor : neighbors) queue.offer(neighbor);
            }
            /* Add one to distance */
            distance++;
        }
        
        return 0;
    }
    
    private List<String> getNeighbors(String str, Set<String> wordList) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char[] sa = str.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                sa[i] = ch;
                String next = new String(sa);
                if (wordList.remove(next)) res.add(next);
            }
        }
        return res;
    }
    
}
