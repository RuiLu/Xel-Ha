public class Solution {
    /**
     *  1. consice
     */
    public List<String> findStrobogrammatic(int n) {
        return dfs(n, n);
    }
    
    private List<String> dfs(int n, int m) {
        if (n == 0) return new ArrayList<>(Arrays.asList(""));
        if (n == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));
        
        List<String> tmp = dfs(n - 2, m);
        
        List<String> res = new ArrayList<>();
        
        for (int i = 0; i < tmp.size(); i++) {
            String s = tmp.get(i);
            
            // if n == m, means it is the outmost loop, so add "0" is illegal
            if (n != m) res.add("0" + s + "0");
            
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("9" + s + "6");
            res.add("8" + s + "8");
        }
        
        return res;
    }
    
    /**
     *  2. lots of lines
     */
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        
        List<Character> helper = new ArrayList<>();
        helper.add('0');
        helper.add('1');
        helper.add('6');
        helper.add('8');
        helper.add('9');
        
        int half = n / 2;
        List<String> tmp = new ArrayList<>();
        
        dfs(tmp, helper,new StringBuilder(), half);
        
        for (String left : tmp) {
            StringBuilder sb = new StringBuilder();
            for (char ch : left.toCharArray()) {
                if (ch == '6') ch = '9';
                else if (ch == '9') ch = '6';
                sb.append(ch);
            }
            
            String right = sb.reverse().toString();
            
            if (n % 2 == 0) {
                res.add(left + right);
            } else {
                res.add(left + "0" + right);
                res.add(left + "1" + right);
                res.add(left + "8" + right);
            }
            
        }
        
        return res;
    }
    
    private void dfs(List<String> tmp, List<Character> helper, StringBuilder sb, int limit) {
        if (limit == sb.length()) {
            tmp.add(sb.toString());
            return;
        }
        
        for (int i = 0; i < helper.size(); i++) {
            if (sb.length() == 0 && helper.get(i) == '0') continue;
            
            int len = sb.length();
            sb.append(helper.get(i));
            dfs(tmp, helper, sb, limit);
            sb.setLength(len);  // backtracking.
        }
    }
}
