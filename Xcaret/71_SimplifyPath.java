public class Solution {
    /**
     *  Using a stack-like array
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return "";
        
        String[] tokens = path.split("/");
        String[] stack = new String[tokens.length];
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        for (String token : tokens) {
            if (token.equals(".") || token.equals("")) {
                continue;
            } else if (token.equals("..")) {
                if (count > 0) {
                    count--;
                }
            } else {
                stack[count++] = token;
            }
        }
        
        for (int i = 0; i < count; i++) {
            sb.append("/" + stack[i]);
        }
        
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
