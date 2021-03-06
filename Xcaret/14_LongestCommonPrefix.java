public class Solution {
    /**
     *  First, sort the strs array directly -> O(nklognk)
     *  Second, directly compare the first string and the last string -> O(k)
     *  Time complexity -> O(nklognk)
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        int len = strs.length;
        String res = "";
        Arrays.sort(strs);
        
        for (int i = 0; i < strs[0].length(); i++) {
            char c1 = strs[0].charAt(i);
            char c2 = strs[len-1].charAt(i);
            if (c1 == c2) res += c1;
            else break;
        }
        
        return res;
    } 
    
    /**
     *  First, sort the strs array by their length -> O(nklognk)
     *  Second, find the longest common prefix -> O(nk), where k is the shortest length of str
     *  Therefore, Time complexity in worst case -> O(n^2)
     */
    // public String longestCommonPrefix(String[] strs) {
    //     if (strs == null || strs.length == 0) return "";
        
    //     String res = "";
    //     Arrays.sort(strs, new Comparator<String>(){
    //         public int compare(String s1, String s2) {
    //             return s1.length() - s2.length();
    //         }  
    //     });
        
    //     for (int i = 0; i < strs[0].length(); i++) {
    //         char ch = strs[0].charAt(i);
    //         for (int j = 1; j < strs.length; j++) {
    //             if (ch != strs[j].charAt(i)) return res;
    //         }
    //         res += ch;
    //     }
        
    //     return res;
    // }
}
