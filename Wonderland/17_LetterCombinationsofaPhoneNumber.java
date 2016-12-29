public class Solution {
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        map.put("0", " ");
        helper(res, map, new ArrayList<>(), digits, 0);
        return res;
    }
    
    private void helper(List<String> res, Map<String, String> map, List<String> tmp, String digits, int index) {
        if (index == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (String str : tmp) sb.append(str);
            res.add(sb.toString());
            return;
        }
        
        String curr = map.getOrDefault(String.valueOf(digits.charAt(index)), "");
        for (int i = 0; i < curr.length(); i++) {
            String s = String.valueOf(curr.charAt(i));
            tmp.add(s);
            helper(res, map, tmp, digits, index + 1);
            tmp.remove(tmp.size() - 1);
        }
        
    }
    
}
