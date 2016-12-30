public class Solution {
    
    private boolean isPalindrome(String s) {
        int lo = 0;
        int hi = s.length() - 1;
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) return false;
            lo++;
            hi--;
        }
        return true;
    }
    
    /**
     *  Idea -> Using HashMap, see comments for details
     *  Time complexity -> O(nm)
     *  Space complexity -> O(n)
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> rst = new ArrayList<>();
        if (words == null || words.length < 2) return rst;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        // put every word/index pair into map
        for (int i = 0; i < words.length; i++) map.put(words[i], i);
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            // chech every substring of every word, and see if it can form a palindrome with other word in map.
            for (int j = 0; j <= word.length(); j++) {
                String part1 = word.substring(0, j);
                String part2 = word.substring(j);
                
                if (isPalindrome(part1)) {
                    String part2Reverse = new StringBuilder(part2).reverse().toString();
                    if (map.containsKey(part2Reverse) && map.get(part2Reverse) != i) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(map.get(part2Reverse));
                        tmp.add(i);
                        rst.add(new ArrayList<>(tmp));
                    }
                }
                if (isPalindrome(part2)) {
                    String part1Reverse = new StringBuilder(part1).reverse().toString();
                    // check part2.length() != 0 to avoid duplicate
                    if (map.containsKey(part1Reverse) && map.get(part1Reverse) != i && part2.length() != 0) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(i);
                        tmp.add(map.get(part1Reverse));
                        rst.add(new ArrayList<>(tmp));
                    }
                }
            }
        }
        
        return rst;
    }
    
    /**
     *  Idea -> Naive way, Time Limit Exceeded.
     *  Time complexity -> O(n^2)
     */
    // public List<List<Integer>> palindromePairs(String[] words) {
    //     List<List<Integer>> result = new ArrayList<>();
    //     if (words == null || words.length == 0) return result;
        
    //     for (int i = 0; i < words.length - 1; i++) {
    //         for (int j = i + 1; j < words.length; j++) {
    //             List<Integer> tmp = null;
    //             String combine = words[i] + words[j];
    //             if (isPalindrome(combine)) {
    //                 tmp = new ArrayList<>();
    //                 tmp.add(i);
    //                 tmp.add(j);
    //                 result.add(new ArrayList<>(tmp));
    //             }
    //             combine = words[j] + words[i];
    //             if (isPalindrome(combine)) {
    //                 tmp = new ArrayList<>();
    //                 tmp.add(j);
    //                 tmp.add(i);
    //                 result.add(new ArrayList<>(tmp));
    //             }
    //         }
    //     }
        
    //     return result;
    // }
    
}
