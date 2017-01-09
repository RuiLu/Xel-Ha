public class Solution {
    /**
     *  Idea -> Backtracking, see comments for details.
     *          
     *  Time complexity -> O(2^n), where n is the length of the word
     */
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        if (word == null || word.length() == 0) {
            res.add("");
            return res;
        }
        helper(word, res, "", 0, 0);
        return res;
    }
    
    /**
     * @curr    - current status of abbreviation 
     * @index   - the position of current pointer
     * @count   - the length of current abbreviation
     */
    private void helper(String word, List<String> res, String curr, int index, int count) {
        /* If index reaches the end of word, add it into result ArrayList */
        if (index == word.length()) {
            /* Add count if count is bigger than 0 */
            if (count > 0) curr += count;   
            res.add(curr);
        } else {
            /* First case, add count and ignore the current character */
            helper(word, res, curr, index+1, count+1);
            /* Second case, add count and current character into current abbreviation, then reset count */
            helper(word, res, curr+(count == 0 ? "" : count)+word.charAt(index), index+1, 0);
        }
    }
     
    /**
     *  Idea -> Divide and conquer
     */
    // public List<String> generateAbbreviations(String word) {
    //     List<String> res = new ArrayList<>();
    //     if (word == null || word.length() == 0) {
    //         res.add("");
    //         return res;
    //     }
    //     HashSet<String> set = new HashSet<>();
    //     List<String> list = helper(word, 0, word.length()-1);
    //     for (String str : list) {
    //         if (set.add(str)) res.add(str);
    //     }
    //     return res;
    // }
    
    // private List<String> helper(String s, int lo, int hi) {
    //     List<String> list = new ArrayList<>();
    //     if (lo > hi) {
    //         list.add("");
    //         return list;
    //     }
        
    //     int len = hi-lo+1;
    //     list.add(s.substring(lo, hi+1));
        
    //     for (int i = 0; i < len; i++) {
    //         for (int j = lo; j <= hi && j+i <= hi; j++) {
    //             String mid = s.substring(Math.max(j-1, lo), j) +
    //                          (i+1) +
    //                          s.substring(Math.min(j+i+1, hi+1), Math.min(j+i+2, hi+1));
    //             List<String> leftPart = helper(s, lo, j-2);
    //             List<String> rightPart = helper(s, j+i+2, hi);
    //             for (String left : leftPart) {
    //                 for (String right : rightPart) {
    //                     // System.out.println(left + " " + mid + " " + right);
    //                     list.add(left+mid+right);
    //                 }
    //             }
    //         }
    //     }
        
    //     return list;
    // }
}
