public class Solution {
    /**
     *  Idea -> Common idea
     *  Time complexity -> O(n)
     */
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 2) return res;
        
        char prev = s.charAt(0);
        
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (prev == curr && curr == '+') {
                StringBuilder sb = new StringBuilder();
                if (i > 1) {
                    sb.append(s.substring(0, i - 1)).append("--").append(s.substring(i + 1));
                } else {
                    sb.append("--").append(s.substring(i + 1));
                }
                res.add(sb.toString());
            } else {
                prev = curr;
            }
        }
        
        return res;
    }
}
