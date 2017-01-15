public class WordDistance {
    /**
     *  Since shortest() will be called many times repeatedly.
     *  So I decide to pre-process words array, take out every word and its indices.
     */
    private HashMap<String, ArrayList<Integer>> map; 
     
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!map.containsKey(word)) map.put(word, new ArrayList<>());
            map.get(word).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        int minDist = Integer.MAX_VALUE;
        ArrayList<Integer> list1 = map.get(word1);
        ArrayList<Integer> list2 = map.get(word2);
        
        for (int idx1 : list1) {
            for (int idx2 : list2) {
                minDist = Math.min(minDist, Math.abs(idx1-idx2));
            } 
        }
        
        return minDist;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
