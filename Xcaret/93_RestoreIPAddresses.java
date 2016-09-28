public class Solution {
    /**
     *  Backtracking
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) return res;
        
        List<String> tmp = new ArrayList<>(); 
        helper(s, res, tmp, 0);
        
        return res;
    }
    
    private void helper(String s, List<String> res, List<String> tmp, int count) {
        if (count < 4 && s.equals("")) return;
        
        if (count == 4 && s.equals("")) {
            res.add(tmp.get(0)+"."+tmp.get(1)+"."+tmp.get(2)+"."+tmp.get(3));
            return;
        }
        
        for (int i = 1; i <= 3 && i <= s.length(); i++) {
            String str = s.substring(0, i);
            if (isValid(str)) {
                tmp.add(str);
                helper(s.substring(i), res, tmp, count + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    
    private boolean isValid(String value) {
        /* first -> only 0 is allowed, any others like 010, 00 are not allowed */
        if (value.charAt(0) == '0' && value.length() > 1) return false;
        /* second -> only number that is between 0 and 255 is allowed */
        int num = Integer.parseInt(value);
        return num >= 0 && num <= 255;
    }
}
