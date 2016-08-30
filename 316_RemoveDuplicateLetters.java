public class Solution {
    /**
     *  2. Stack
     *  Reference -> https://discuss.leetcode.com/topic/43469/java-o-n-solution-using-stack-with-detail-explanation
     *  Time complexity -> O(n)
     */
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) return s;
        
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        
        for (char ch : s.toCharArray()) count[ch - 'a']++;
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            count[curr - 'a']--;
            
            if (visited[curr - 'a']) continue;
            
            visited[curr - 'a'] = true;
            
            while (!stack.isEmpty() && stack.peek() > curr && count[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            
            stack.push(curr);
        }
        
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) sb.append(ch);
        
        return sb.toString();
    }
    
    /**
     *  1. Iteration with a map.
     *  Reference -> https://discuss.leetcode.com/topic/31413/easy-to-understand-iterative-java-solution/2
     *  Time complexity -> O(nk), where k is the average size of map
     *  Space complexity -> O(k)
     */
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) return s;
        
        Map<Character, Integer> lastPosMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) lastPosMap.put(s.charAt(i), i);
        
        char[] res = new char[lastPosMap.size()];
        int left = 0, right = findMinInMap(lastPosMap);
        
        for (int i = 0; i < res.length; i++) {
            char minChar = 'z' + 1;
            for (int j = left; j <= right; j++) {
                if (lastPosMap.containsKey(s.charAt(j)) && s.charAt(j) < minChar) {
                    minChar = s.charAt(j);
                    left = j + 1;   // move left 
                }
            }
            
            res[i] = minChar;
            if (i == res.length - 1) break;
            
            lastPosMap.remove(minChar);
            if (minChar == s.charAt(right)) right = findMinInMap(lastPosMap);
        }
        
        return new String(res);
    }
    
    private int findMinInMap(Map<Character, Integer> map) {
        int min = Integer.MAX_VALUE;
        for (int val : map.values()) min = Math.min(min, val);
        return min;
    }
}
