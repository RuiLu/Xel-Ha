public class Solution {
    
    /*
     * 1. Brute Force : TLE 
     * /
    // public List<List<Integer>> palindromePairs(String[] words) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     if (words == null || words.length <= 1) return res;
    //     for (int i = 0; i < words.length; i++) {
    //         for (int j = 0; j < words.length; j++) {
    //             if (i == j || (words[i].length() == 0 && words[j].length() == 0)) continue;
    //             String combined = words[i] + words[j];
    //             int end = combined.length() - 1;
    //             int start = 0;
    //             boolean isFound = true;
    //             while (start < end) {
    //                 if (combined.charAt(start) != combined.charAt(end)) isFound = false;
    //                 start++;
    //                 end--;
    //             }
    //             if (isFound) {
    //                 res.add(new ArrayList<Integer>(Arrays.asList(i, j)));
    //             }
    //         }
    //     }
    //     return res;
    // }
    
    /*
     * 2. HashMap
     * Should consider 4 situation: 1. s1 or s2 == ""; 2. s1 == s2.reverse; 
     * 3. s1.substring(cut + 1) is Palindrome and s1.substring(0, cut + 1).reverse = s2.substring(cut + 1); 
     * 4. s1.substring(0, cut + 1) is Palindrome and s1.substring(cut + 1).reverse = s2.substring(0, cut + 1)
     */
     public List<List<Integer>> palindromePairs(String[] words) {
         List<List<Integer>> res = new ArrayList<>();
         if (words == null || words.length <= 1) return res;
         
         HashMap<String, Integer> map = new HashMap<>();
         for (int i = 0; i < words.length; i++) {
             map.put(words[i], i);
         }
         
         // case 1
         if (map.containsKey("")) {
             int index = map.get("");
             for (int i = 0; i < words.length; i++) {
                 if (i == index) continue;
                 if (isPalindrome(words[i])) {
                     res.add(new ArrayList<>(Arrays.asList(i, index)));
                     res.add(new ArrayList<>(Arrays.asList(index, i)));
                 }
             }
         }
         
         // case 2
         for (int i = 0; i < words.length; i++) {
             String reverse = reverseString(words[i]);
             if (map.containsKey(reverse)) {
                 int index = map.get(reverse);
                 if (index == i) continue;
                 res.add(new ArrayList<>(Arrays.asList(i, index)));
             }
         }
         
         // case 3 & 4
         for (int i = 0; i < words.length; i++) {
             String cur = words[i];
             for (int j = 1; j < cur.length(); j++) {
                 if (isPalindrome(cur.substring(0, j))) {
                     String reverse = reverseString(cur.substring(j));
                     if (map.containsKey(reverse)) {
                         int index = map.get(reverse);
                         if (index == i) continue;
                         res.add(new ArrayList<>(Arrays.asList(index, i)));
                     }
                 }
                 if (isPalindrome(cur.substring(j))) {
                     String reverse = reverseString(cur.substring(0, j));
                     if (map.containsKey(reverse)) {
                         int index = map.get(reverse);
                         if (index == i) continue;
                         res.add(new ArrayList<>(Arrays.asList(i, index)));
                     }
                 }
             }
         }
         return res;
     }
     
     private String reverseString(String string) {
         StringBuilder sb = new StringBuilder(string);
         return sb.reverse().toString();
     }
     
     private boolean isPalindrome(String string) {
         int start = 0, end = string.length() -1;
         while (start <= end) {
             if (string.charAt(start++) != string.charAt(end--)) return false;
         }
         return true;
     }
     
     /*
      * 3. Trie, leave it for now
      */ 
}
