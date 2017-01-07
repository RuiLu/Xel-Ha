public class Solution {
    /**
     *  Idea -> Use a Array acting as HashMap
     *          Because we know the string contains only lowercase letters,
     *          so we can initialize a arr with length 26, and assign value on every position to -1.
     *          If a character appears only once, let's say ch, then arr[ch-'a'] == index.
     *          If a character appears twice, let's say ch, then arr[ch-'a'] == -2.
     *          At last, we traverse arr and find the minimal index with value >= 0.
     * 
     *  Time complexity -> O(n)
     *  Space complexity -> O(26)
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        if (s.length() == 1) return 0;
        
        int res = Integer.MAX_VALUE;
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i)-'a';
            if (arr[idx] == -2) continue;
            else if (arr[idx] == -1) arr[idx] = i;
            else arr[idx] = -2;
        }
        
        for (int i = 0; i < 26; i++) {
            if (arr[i] == -2 || arr[i] == -1) continue;
            res = Math.min(res, arr[i]);
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
