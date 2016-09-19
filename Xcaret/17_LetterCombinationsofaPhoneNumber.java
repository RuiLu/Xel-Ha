public class Solution {
    /**
     *  backtracking
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
        
        helper(digits.toCharArray(), new StringBuilder(), res, map, 0);
        
        return res;
    }
    
    private void helper(char[] digits, StringBuilder sb, List<String> res, Map<Character, String> map, int idx) {
        if (idx == digits.length) {
            res.add(sb.toString());
            return;
        } 
        
        String values = map.getOrDefault(digits[idx], "");
        for (char ch : values.toCharArray()) {
            sb.append(ch);
            helper(digits, sb, res, map, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
