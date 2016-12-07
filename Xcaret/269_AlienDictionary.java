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
        
        HashMap<Character, HashSet<Character>> map = new HashMap<Character, HashSet<Character>>();
        HashMap<Character, Integer> degree = new HashMap<Character, Integer>();
        
        /* 1. add every character into degree */
        for (String word : words) {
            for (char ch : word.toCharArray()) degree.put(ch, 0);
        }
        
        /* 2. add degree to character, according to the first different character between adjacent words */
        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i+1];
            int len = Math.min(curr.length(), next.length());
            for (int j = 0; j < len; j++) {
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    HashSet<Character> set = new HashSet<Character>();
                    if (map.containsKey(c1)) set = map.get(c1);
                    if (!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                } else {
                    /* If the current length is longer than the next length, indicating given words are invalid */
                    if (j + 1 < curr.length() && j + 1 >= next.length()) return "";
                }
            }
        }
        
        /* 3. add character with degree 0 to queue */
        Queue<Character> queue = new LinkedList<Character>();
        for (Map.Entry<Character, Integer> me : degree.entrySet()) {
            if (me.getValue() == 0) queue.offer(me.getKey());
        }
        
        /* 4. using BFS to do topological sort */
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            sb.append(curr);
            if (map.containsKey(curr)) {
                for (char next : map.get(curr)) {
                    degree.put(next, degree.get(next) - 1);
                    if (degree.get(next) == 0) queue.offer(next);
                }
            }
        }
        
        /* 5. make sure all characters have been used (degree contains all characters */
        if (sb.length() != degree.size()) return "";
        else return sb.toString();
    }
}
