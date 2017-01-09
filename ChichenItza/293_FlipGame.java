public class Solution {
    /**
     *  Idea -> One-pass traversal.
     */
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() <= 1) return res;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i+1) == '+') {
                res.add(s.substring(0, i)+"--"+s.substring(i+2));
            }
        }
        return res;
    }
}
