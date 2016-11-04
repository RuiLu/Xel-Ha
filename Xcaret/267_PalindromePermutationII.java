public class Solution {
    /**
     *  Idea -> First determine if the given string is palindrome, if not, return empty.
     *          Otherwise, if the lengthe is odd, find the mid, and construct palindrome from both sides of mid.
     *  Time complexity -> O((n/2)^(n/2)) in worst case, where n is the length of String
     */
    private static void getAllPermutations(Map<Character, Integer> map, List<String> res, String mid, int len) {
        if (mid.length() == len) {
            res.add(mid);
        } else {
            for (Map.Entry<Character, Integer> me : map.entrySet()) {
                if (me.getValue() <= 0) continue;
                map.put(me.getKey(), me.getValue() - 2);
                mid = me.getKey() + mid + me.getKey();
                getAllPermutations(map, res, mid, len);
                mid = mid.substring(1, mid.length() - 1);
                map.put(me.getKey(), me.getValue() + 2);
            }
        }
    }

    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        
        int len = s.length();
        int oddCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for (char ch : s.toCharArray()) {
            if (!map.containsKey(ch)) map.put(ch, 0);
            map.put(ch, map.get(ch) + 1);
            oddCount += map.get(ch) % 2 != 0 ? 1 : -1;
        }
        
        if (oddCount != 1 && oddCount != 0) return res;
        
        String mid = "";
        for (Map.Entry<Character, Integer> me : map.entrySet()) {
            if (me.getValue() % 2 != 0) {
                mid += me.getKey();
                map.put(me.getKey(), me.getValue() - 1);
            }
        }
        
        getAllPermutations(map, res, mid, len);
        
        return res;
    }
}
