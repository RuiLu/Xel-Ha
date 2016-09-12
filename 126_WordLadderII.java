public class Solution {
    /**
     *  Reference -> https://discuss.leetcode.com/topic/2857/share-two-similar-java-solution-that-accpted-by-oj/2
     *  In general, use BFS to construct a graph, then use DFS to construct path from end to start
     */
    List<List<String>> results;
    Map<String, List<String>> map;
    
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        results = new ArrayList<>();
        if (wordList.size() == 0) return results;
        
        map = new HashMap<>();
        
        int min = Integer.MAX_VALUE;
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        Map<String, Integer> ladder = new HashMap<>();
        for (String word : wordList) ladder.put(word, Integer.MAX_VALUE);
        ladder.put(beginWord, 0);
        
        wordList.add(endWord);
        
        while (!queue.isEmpty()) {
            String word = queue.poll();
            
            int step = ladder.get(word) + 1;
            if (step > min) break;
            
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                for (char c = 'a'; c <= 'z'; c++) {
                    sb.setCharAt(i, c);
                    String next = sb.toString();
                    
                    if (ladder.containsKey(next)) {
                        if (step > ladder.get(next)) continue;  // check if it is the shortest path
                        else if (step < ladder.get(next)) {
                            ladder.put(next, step);
                            queue.offer(next);
                        }
                        
                        if (map.containsKey(next)) {
                            map.get(next).add(word);
                        } else {
                            List<String> list = new ArrayList<>();
                            list.add(word);
                            map.put(next, list);
                        }
                        
                        if (next.equals(endWord)) min = step;
                    }
                }
            }
        }
        
        List<String> res = new LinkedList<>();
        backtracking(endWord, beginWord, res);
        
        return results;
    }
    
    private void backtracking(String word, String start, List<String> list) {
        if (word.equals(start)) {
            list.add(0, start);
            results.add(new ArrayList<>(list));
            list.remove(0); // backtracking
            return;
        }
        
        list.add(0, word);
        if (map.get(word) != null) {
            for (String next : map.get(word)) backtracking(next, start, list);
        }
        list.remove(0);     // backtracking
    }
}
