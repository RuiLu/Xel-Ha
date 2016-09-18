public class Solution {
    /**
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public String convert(String s, int numRows) {
        if (numRows == 1 || s== null || s.length() <= 1) return s;
        
        List<Character>[] lists = new List[numRows];
        
        // for (int i = 0; i < numRows; i++) lists.add(new ArrayList<>());
        
        boolean down = true;
        int k = 0;
        
        for (char c : s.toCharArray()) {
            if (lists[k] == null) lists[k] = new ArrayList<>();
            lists[k].add(c);
            
            if (down && k == numRows - 1) {
                down = false;
            } else if (!down && k == 0) {
                down = true;
            }
            
            if (down) k++;
            else k--;
        }
        
        StringBuilder sb = new StringBuilder();
        for (List<Character> list : lists) {
            if (list != null) {
                for (char ch : list) sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}
