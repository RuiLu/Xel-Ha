public class Solution {
    /**
     * Idea -> Assign each path a value, then use Dijkstra's algorithm
     */
    private Map<String, Set<String>> map;
    private List<List<String>> res;
     
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        res = new ArrayList<>();
        if (wordList.size() == 0) return res;
        
        int min = Integer.MAX_VALUE;
        map = new HashMap<>();
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        Map<String, Integer> ladder = new HashMap<>();
        for (String word : wordList) ladder.put(word, Integer.MAX_VALUE);
        ladder.put(beginWord, 0);
        
        wordList.add(endWord);
        
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            int step = ladder.get(curr)+1;
            
            if (step > min) break;
            
            for (int i = 0; i < curr.length(); i++) {
                StringBuilder sb = new StringBuilder(curr);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    sb.setCharAt(i, ch);
                    String next = sb.toString();
                    
                    if (ladder.containsKey(next)) {
                        int dist = ladder.get(next);
                        if (step > dist) continue;
                        else if (step < dist) {
                            queue.offer(next);
                            ladder.put(next, step);
                        }
                        
                        if (!map.containsKey(next)) map.put(next, new HashSet<>());
                        map.get(next).add(curr);
                        
                        if (next.equals(endWord)) min = step;
                    }
                }
            }
        }
        
        List<String> tmp = new ArrayList<>();
        createAllPaths(endWord, beginWord, tmp);
        
        return res;
    }
    
    private void createAllPaths(String word, String begin, List<String> tmp) {
        if (word.equals(begin)) {
            tmp.add(0, word);
            res.add(new ArrayList<>(tmp));
            tmp.remove(0);
            return;
        }
        
        tmp.add(0, word);
        if (map.containsKey(word)) {
            for (String next : map.get(word)) createAllPaths(next, begin, tmp);
        }
        tmp.remove(0);
    }
    
    /**
     * Idea -> Use one-way BFS to find the shortest path from begin to end.
     *         In the meantime, maintaining a HashMap, whose key is child, value is list of parent.
     *         Finally, use DFS to get the path.
     */
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList.size() == 0) return res;
        
        Queue<String> queue = new LinkedList<>();
        Map<String, Set<String>> map = new HashMap<>();
        boolean found = false;
        
        queue.offer(beginWord);
        wordList.add(endWord);
        wordList.remove(beginWord);
        
        /* BFS to create child and parent map */
        while (!queue.isEmpty()) {
            /* check all neighbors for all words in current distance */
            int size = queue.size();
            /* record word been visited in this round, then, remove these visited words from wordList. */
            HashSet<String> visited = new HashSet<>();
            
            while (size-- > 0) {
                String curr = queue.poll();
                char[] ca = curr.toCharArray();
                
                for (int i = 0; i < curr.length(); i++) {
                    char old = ca[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        ca[i] = ch;
                        String next = new String(ca);
                        if (next.equals(endWord) && !found) found = true;
                        
                        if (wordList.contains(next)) {
                            /* update child and parent map */
                            if (!map.containsKey(next)) map.put(next, new HashSet<>());
                            map.get(next).add(curr);
                            /* update queue and wordList */
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                    ca[i] = old;
                }
            }
            
            wordList.removeAll(visited);
            if (found) break;
        }
        
        /* DFS to create path list */
        List<String> tmp = new ArrayList<>();
        createAllPaths(endWord, beginWord, map, res, tmp);
        
        return res;
    }
    
    private void createAllPaths(String word, String begin, Map<String, Set<String>> map, 
                                List<List<String>> res, List<String> tmp) {
        /* backtracking */
        if (word.equals(begin)) {
            tmp.add(0, word);
            res.add(new ArrayList<>(tmp));
            tmp.remove(0);
            return;
        }
        
        tmp.add(0, word);
        if (map.containsKey(word)) {
            for (String parent : map.get(word)) createAllPaths(parent, begin, map, res, tmp);   
        }
        tmp.remove(0);
    }
}
