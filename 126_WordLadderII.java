public class Solution {
    /**
     *  Reference -> https://discuss.leetcode.com/topic/2857/share-two-similar-java-solution-that-accpted-by-oj/2
     *  In general, use BFS to construct a graph, then use DFS to construct path from end to start
     */
    Map<String, List<String>> map;
    List<List<String>> res;
    
    public List<List<String>> findLadders(String startWord, String endWord, Set<String> wordList) {
        res = new ArrayList<>();
        if (wordList.size() == 0) return res;
        
        map = new HashMap<>();
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(startWord);
        
        Map<String, Integer> ladder = new HashMap<>();
        for (String word : wordList) ladder.put(word, Integer.MAX_VALUE);
        ladder.put(startWord, 0);
        
        int min = Integer.MAX_VALUE;
        
        wordList.add(endWord);
        
        /* BFS -> Dijisktra search */
        while (!queue.isEmpty()) {
            String word = queue.poll();
            
            int step = ladder.get(word) + 1;
            if (step > min) break;
            
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    sb.setCharAt(i, ch);
                    String next = sb.toString();
                    
                    if (ladder.containsKey(next)) {
                        if (ladder.get(next) < step) continue;
                        else if (ladder.get(next) > step) {
                            ladder.put(next, step);
                            queue.offer(next);
                        }
                        
                        if (!map.containsKey(next)) map.put(next, new ArrayList<>());
                        map.get(next).add(word);
                        
                        if (next.equals(endWord)) min = step;
                    }
                }
            }
        }
        
        /* Backtracking */
        List<String> tmp = new LinkedList<>();
        backtracking(endWord, startWord, tmp);
        
        return res;
    }
    
    private void backtracking(String word, String start, List<String> tmp) {
        if (word.equals(start)) {
            tmp.add(0, start);
            res.add(new ArrayList<>(tmp));
            tmp.remove(0);
            return;
        }
        
        tmp.add(0, word);
        if (map.get(word) != null) {
            for (String next : map.get(word)) backtracking(next, start, tmp);
        }
        tmp.remove(0);
    }
}
