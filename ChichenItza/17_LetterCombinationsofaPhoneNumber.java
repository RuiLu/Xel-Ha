public class Solution {
    /**
     *  Idea -> Backtracking + DFS
     *  Time complexity -> O(3^n)
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        map.put('0', " ");
        
        dfs(digits, res, "", map, 0);
        
        return res;
    }
    
    private void dfs(String s, List<String> res, String curr, Map<Character, String> map, int idx) {
        if (idx == s.length()) {
            res.add(curr);
            return;
        } 
        
        String next = map.getOrDefault(s.charAt(idx), "");
        for (char ch : next.toCharArray()) {
            dfs(s, res, curr+ch, map, idx+1);
        }
    }
}
