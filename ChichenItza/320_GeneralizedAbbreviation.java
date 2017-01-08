public class Solution {
    /**
     *  Idea -> Divide and conquer
     */
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        if (word == null || word.length() == 0) {
            res.add("");
            return res;
        }
        HashSet<String> set = new HashSet<>();
        List<String> list = helper(word, 0, word.length()-1);
        for (String str : list) {
            if (set.add(str)) res.add(str);
        }
        return res;
    }
    
    private List<String> helper(String s, int lo, int hi) {
        List<String> list = new ArrayList<>();
        if (lo > hi) {
            list.add("");
            return list;
        }
        
        int len = hi-lo+1;
        list.add(s.substring(lo, hi+1));
        
        for (int i = 0; i < len; i++) {
            for (int j = lo; j <= hi && j+i <= hi; j++) {
                String mid = s.substring(Math.max(j-1, lo), j) +
                             (i+1) +
                             s.substring(Math.min(j+i+1, hi+1), Math.min(j+i+2, hi+1));
                List<String> leftPart = helper(s, lo, j-2);
                List<String> rightPart = helper(s, j+i+2, hi);
                for (String left : leftPart) {
                    for (String right : rightPart) {
                        // System.out.println(left + " " + mid + " " + right);
                        list.add(left+mid+right);
                    }
                }
            }
        }
        
        return list;
    }
}
