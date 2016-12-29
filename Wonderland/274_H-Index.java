public class Solution {
    /**
     * First Attempt -> Time complexity -> O(nlogn)
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        for (int i = 0; i < citations.length; i++) {
            if (len <= citations[i]) return len;    // at least
            else len--;
        }
        
        return 0;
    }
    
    /**
     * Second Attempt -> Time complexity -> O(n), but needing more space
     * The value of count[i] means that there are count[i] papers that have i citations.
     * The value of last element (count[len]) means that there are count[len] papers that have at least i citations
     */
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] count = new int[len + 1];
        
        for (int citation : citations) {
            if (citation > len) count[len]++;
            else count[citation]++;
        }
        
        int total = 0;
        for (int index = len; index >= 0; index--) {
            total += count[index];
            if (index <= total) return index;
        }
        
        return 0;
    }
}
