public class Solution {
    /**
     *  Topological Sort.
     *  This kind of questions can be seen as a directed graph
     *  "The usual algorithms for topological sorting have running time linear in the number of nodes plus the number of edges, asymptotically"
     *  Reference -> 1. https://en.wikipedia.org/wiki/Topological_sorting
     *               2. https://discuss.leetcode.com/topic/28308/java-ac-solution-using-bfs/35
     */
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        String res = "";
        
        /* 1. Add every character into degree */
        for (String word : words) {
            for (char ch : word.toCharArray()) degree.put(ch, 0);
        }
        
        /* 2. Add degree to character, according to the first different character between two adjacent words */
        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i+1];
            int len = Math.min(curr.length(), next.length());
            
            for (int j = 0; j < len; j++) {
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
                } else {
                    /* Avoid the situation that ["wrtkj", "wrt"], which is not allowed  */
                    if (j + 1 <= curr.length() - 1 && j + 1 > next.length() - 1) return "";
                }
            }
        }
        
        /* 3. Add character with 0 degree to queue */
        Queue<Character> queue = new LinkedList<>();
        for (char ch : degree.keySet()) {
            if (degree.get(ch) == 0) queue.offer(ch);
        }
        
        /* 4. Use bfs to do topological sort */
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            res += curr;
            
            if (map.containsKey(curr)) {
                for (char next : map.get(curr)) {
                    degree.put(next, degree.get(next) - 1);
                    if (degree.get(next) == 0) queue.offer(next);
                }
            }
        }
        
        /* 5. Make sure all characters are used */
        if (res.length() != degree.size()) return "";
        
        return res;
    }
}
