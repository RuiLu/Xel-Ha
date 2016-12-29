public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() <= 1 || s.equals("--")) return res;
        
        int len = s.length();
        
        for (int i = 0; i < len - 1; i++) {
            String sub = s.substring(i, i + 2);
            if (sub.equals("++")) {
                res.add(s.substring(0, i) + "--" + (i == len - 2 ? "" : s.substring(i + 2)));
            }
        }
        
        return res;
    }
}
