public class Solution {
    /**
     *  Idea -> First determine if the given string is palindrome, if not, return empty.
     *          Otherwise, if the lengthe is odd, find the mid, and construct palindrome from both sides of mid.
     */
    private static void getAllPermutations(List<String> res, Map<Character, Integer> map, String mid, int len) {
        if (mid.length() == len) {
            res.add(mid);
        } else {
            for (char ch : map.keySet()) {
                if (map.get(ch) <= 0) continue;
                mid = ch + mid + ch;
                map.put(ch, map.get(ch) - 2);
                getAllPermutations(res, map, mid, len);
                mid = mid.substring(1, mid.length() - 1);
                map.put(ch, map.get(ch) + 2);
            }
        }
    }
    
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int oddCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!map.containsKey(curr)) map.put(curr, 0);
            map.put(curr, map.get(curr) + 1);
            oddCount += map.get(curr) % 2 == 0 ? -1 : 1;
        }
        
        /* not palindrome */
        if (oddCount != 0 && oddCount != 1) return res;
        
        String mid = "";
        for (char ch : map.keySet()) {
            if (map.get(ch) % 2 != 0) {
                mid += ch;
                map.put(ch, map.get(ch) - 1);
            }
        }
        
        getAllPermutations(res, map, mid, s.length());
        
        return res;
    }
}
