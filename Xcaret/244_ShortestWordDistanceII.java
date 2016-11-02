public class WordDistance {
    /**
     *  Idea -> Using Map to keep track all words and their indices
     */
    private String[] words = null;
    private Map<String, List<Integer>> map = null;
    
    public WordDistance(String[] words) {
        this.words = words;
        map = new HashMap<>();
        
        for (int i = 0; i < words.length; i++) {
            List<Integer> list = map.getOrDefault(words[i], new ArrayList<>());
            list.add(i);
            map.put(words[i], list);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int minGap = Integer.MAX_VALUE;
        
        for (int i1 : l1) {
            for (int i2 : l2) {
                minGap = Math.min(minGap, Math.abs(i1 - i2));
            }
        }
        
        return minGap;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
