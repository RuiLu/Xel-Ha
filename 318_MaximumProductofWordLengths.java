public class Solution {
    /**
     *  2. Bit Manipulation -> brilliant thought!
     *  Reference + explanation -> https://discuss.leetcode.com/topic/35539/java-easy-version-to-understand
     *  Self explanation -> int has 32-bits, we can use the lower 26 bit to express characters from 'a' to 'z'
     *                      for example, if the lowest bit is set to 1, means that this word has at least one 'a'
     *                      so when comparing, we just need to do 'and' operation between two words, see if result is 0
     */
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;
        
        int len = words.length;
        int[] bitCount = new int[len];
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                bitCount[i] |= 1 << (ch - 'a');
            }
        }
        
        int res = Integer.MIN_VALUE;
        
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bitCount[i] & bitCount[j]) == 0) {
                    res = Math.max(res, (words[i].length() * words[j].length()));
                }
            }
        }
        
        return res == Integer.MIN_VALUE ? 0 : res;
    }
     
    /**
     *  1. ArrayList + HashMap -> TLE, of course
     */
    // public int maxProduct(String[] words) {
    //     if (words == null || words.length == 0) return 0;
    //     List<Map<Character, Integer>> lists = new ArrayList<>();
        
    //     for (String word : words) {
    //         Map<Character, Integer> map = new HashMap<>();
    //         for (int i = 0; i < word.length(); i++) {
    //             char ch = word.charAt(i);
    //             if (!map.containsKey(ch)) map.put(ch, 1);
    //             else map.put(ch, map.get(ch) + 1);
    //         }
    //         lists.add(map);
    //     }
        
    //     int res = Integer.MIN_VALUE;
        
    //     for (int i = 0; i < lists.size(); i++) {
    //         Map<Character, Integer> map1 = lists.get(i);
    //         for (int j = 0; j < lists.size(); j++) {
    //             if (i == j) continue;
    //             Map<Character, Integer> map2 = lists.get(j);
                
    //             int len1 = 0;
    //             int len2 = 0;
    //             boolean dup = false;
                
    //             for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
    //                 if (map2.containsKey(entry.getKey())) {
    //                     dup = true;
    //                     break;
    //                 }
    //                 len1 += entry.getValue();
    //             }
                
    //             if (dup) continue;
                
    //             for (Map.Entry<Character, Integer> entry : map2.entrySet()) len2 += entry.getValue();
                
    //             res = Math.max(res, len1 * len2);
    //         }
    //     }
        
    //     return res == Integer.MIN_VALUE ? 0 : res;
    // }
}
