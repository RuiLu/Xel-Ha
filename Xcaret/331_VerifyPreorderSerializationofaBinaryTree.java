public class Solution {
    /**
     *  Idea -> all non-null node provides 2 outdegree and 1 indegree (2 children and 1 parent), except root.
     *          all null node provides 0 outdegree and 1 indegree (0 child and 1 parent).
     *          diff = outdegree - indegree.
     *          In the end, the diff should be 0 if the preorder is valid.
     *  Reference -> https://discuss.leetcode.com/topic/35976/7-lines-easy-java-solution
     *  Time complexity -> O(n)
     */
    public boolean isValidSerialization(String preorder) {
        String[] tokens = preorder.split(",");
        int diff = 1;
        for (String token : tokens) {
            if (--diff < 0) return false;
            if (!token.equals("#")) diff += 2;
        }
        return diff == 0;
    }
    
    /**
     *  Idea -> Use a stack.
     *          Every two "#" has a corresponding number.
     *  Time complexity -> O(n)
     */
    public boolean isValidSerialization(String preorder) {
        String[] tokens = preorder.split(",");
        int len = tokens.length;
        if (len == 1 && tokens[0].equals("#")) return true;
        if (len <= 2) return false;
        
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < len; i++) stack.push(tokens[i]);
        
        while (!stack.isEmpty()) {
            int count = 0;
            while (!stack.isEmpty() && stack.peek().equals("#")) {
                count++;
                stack.pop();
            }
            
            if (stack.isEmpty() || count < 2) return false;
            stack.pop();
            if (stack.size() == 0 && count == 2) return true;
            
            stack.push("#");
            int diff = count - 2;
            while (diff-- > 0) {
                stack.push("#");
            }
        }
        
        return false;
    }

}
