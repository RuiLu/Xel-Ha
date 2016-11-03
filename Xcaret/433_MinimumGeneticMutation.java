public class Solution {
    /**
     *  Idea -> Same idea as WordLadder. BFS + Backtracking
     *          Pay attention to that the end must be in backSet
     *  Time complexity -> O(wn), where w is the length of word
     */
    public int minMutation(String start, String end, String[] bank) {
        if (bank == null || bank.length == 0) return -1;
        
        int len = 0;
        char[] dna = new char[]{'A', 'C', 'G', 'T'};
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Set<String> bankSet = new HashSet<>();
        
        for (String s : bank) bankSet.add(s);
        if (!bankSet.contains(end)) return -1;
        beginSet.add(start);
        endSet.add(end);
        
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            
            Set<String> tmp = new HashSet<>();
            for (String s : beginSet) {
                char[] sca = s.toCharArray();
                for (int i = 0; i < sca.length; i++) {
                    for (int j = 0; j < dna.length; j++) {
                        char old = sca[i];
                        sca[i] = dna[j];
                        String next = String.valueOf(sca);
                        
                        if (endSet.contains(next)) return len + 1;
                        
                        if (bankSet.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            tmp.add(next);
                        }
                        
                        /* Backtracking */
                        sca[i] = old;
                    }
                }
            }
            
            beginSet = tmp;
            len++;
        }
        
        return -1;
    }   
}
