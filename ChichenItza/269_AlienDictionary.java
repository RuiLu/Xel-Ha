public class Solution {
    /**
     *  Idea -> Topological sort
     *  "The usual algorithms for topological sorting have running time linear in the number of nodes plus the number of edges, asymptotically"
     */
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        
        Map<Character, Integer> degree = new HashMap<>();
        Map<Character, Set<Character>> map = new HashMap<>();
        
        /* 1. add every character into degree */
        for (String word : words) {
            for (char ch : word.toCharArray()) degree.put(ch, 0);
        }
        
        /* 2. add degree to character, according to the first different character between two adjcent words 
         *    in the meantime, update map */
        for (int i = 0; i < words.length-1; i++) {
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
                        degree.put(c2, degree.get(c2)+1);
                    }
                    break;
                } else {
                    /* if current length is longer than the next length, meaning that the given words are invalid */
                    if (j+1 < curr.length() && j+1 >= next.length()) return "";
                }
            }
        }
        
        /* 3. add character with 0 degree to queue */
        Queue<Character> queue = new LinkedList<>();
        for (char key : degree.keySet()) {
            if (degree.get(key) == 0) queue.offer(key);
        }
        
        /* 4. use bfs to do topological sort */
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            sb.append(curr);
            if (map.containsKey(curr)) {
                for (char next : map.get(curr)) {
                    degree.put(next, degree.get(next)-1);
                    if (degree.get(next) == 0) queue.offer(next);
                }
            }
        }
        
        /* 5. check if all characters are in StringBuilder */
        if (sb.length() != degree.size()) return "";
        
        return sb.toString();
    }
}
