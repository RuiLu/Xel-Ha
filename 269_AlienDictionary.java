public class Solution {
    /**
     *  Topological Sort.
     *  This kind of questions can be seen as a directed graph
     *  "The usual algorithms for topological sorting have running time linear in the number of nodes plus the number of edges, asymptotically, {\displaystyle O(\left|{V}\right|+\left|{E}\right|)} O(\left|{V}\right|+\left|{E}\right|)."
     *  Reference : 1. https://discuss.leetcode.com/topic/28308/java-ac-solution-using-bfs 
     *              2. https://en.wikipedia.org/wiki/Topological_sorting
     */
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        String res = "";
        
        // 1. add every character into degree
        for (String word : words) {
            for (char ch : word.toCharArray()) degree.put(ch, 0);
        }
        
        // 2. add degree to character, according to the first different character between adjacent word
        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];
            
            int minLen = Math.min(curr.length(), next.length());
            for (int j = 0; j < minLen; j++) {
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);
                
                if (c1 != c2) {
                    Set<Character> set = new HashSet<>();
                    if (map.containsKey(c1)) set = map.get(c1);
                    if (!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        
        // 3. add character with degree 0 to queue
        Queue<Character> queue = new LinkedList<>();
        for (char ch : degree.keySet()) {
            if (degree.get(ch) == 0) queue.offer(ch);
        }
        
        // 4. using BFS to do topological sort
        while (!queue.isEmpty()) {
            char c1 = queue.poll();
            res += c1;
            
            if (map.containsKey(c1)) {
                for (char c2 : map.get(c1)) {
                    degree.put(c2, degree.get(c2) - 1);
                    if (degree.get(c2) == 0) queue.offer(c2);
                }
            }
        }
        
        // 5. make sure all characters have been used (degree contains all characters)
        if (res.length() != degree.size()) return "";
        
        return res;
    }
}
