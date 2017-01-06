public class Solution {
    /**
     *  Idea -> Two pointers
     *  Time complexity -> O(n)
     */
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() == 0) return true;
        
        /* Maintain two pointers, indexS and indexT, while traversing t */
        int indexS = 0;
        int indexT = 0;
        while (indexT < t.length()) {
            /* Once the indexS == s.length(), finish finding, return true */
            if (s.charAt(indexS) == t.charAt(indexT)) indexS++;
            if (indexS == s.length()) return true;
            indexT++;
        }
        
        return false;
    }
    
    /**
     *  Idea -> Record each character's indices
     *  Time complexity -> O(n + mlogk), where n is len(t), m is len(s), 
     *                     k is the average frequency of occurence of characters from s in t.
     */
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() == 0) return true;
        
        /* Create an array for each character in t and its index(es). */
        List<Integer>[] lists = new List[256];
        
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (lists[ch] == null) lists[ch] = new ArrayList<Integer>();
            lists[ch].add(i);
        }
        
        /* Go through each character in s, starting with index 0 */
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (lists[ch] == null) return false;
            /* Use binary search to find index after prev. If not, return false; otherwise, assign index+1 to prev */
            int index = Collections.binarySearch(lists[ch], prev);
            if (index < 0) index = -index-1;
            /* Mean that search fails. */
            if (index == lists[ch].size()) return false;
            prev = lists[ch].get(index)+1;
        }
        
        return true;
    }
}
