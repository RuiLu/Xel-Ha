public class WordDistance {
    
    // First -> HashMap 
    private Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            List<Integer> tmp = map.getOrDefault(words[i], new ArrayList<Integer>());
            if (tmp.size() == 0) {
                tmp.add(i);
                map.put(words[i], tmp);
            } else {
                tmp.add(i);
                map.put(words[i], tmp);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> first = map.get(word1);
        List<Integer> second = map.get(word2);
        
        int res = Integer.MAX_VALUE;
        
        for (Integer i1 : first) {
            for (Integer i2 : second) {
                res = Math.min(res, Math.abs(i1 - i2));
            }
        }
        
        return res;
    }
    
    // Second -> Same idea as Shortest Word Distance I, But TLE here!
    // private String[] words;
    
    // public WordDistance(String[] words) { 
    //     this.words = words;
    // }
    
    // public int shortest(String word1, String word2) {
    //     int res = Integer.MAX_VALUE;
    //     int firstIndex = -1;
    //     int secondIndex = -1;
    //     boolean isChanged = false;
        
    //     for (int i = 0; i < words.length; i++) {
    //         if (words[i].equals(word1)) {
    //             firstIndex = i;
    //             isChanged = true;
    //         }
    //         if (words[i].equals(word2)) {
    //             secondIndex = i;
    //             isChanged = true;
    //         }
    //         if (firstIndex != -1 && secondIndex != -1 && isChanged) {
    //             res = Math.min(res, Math.abs(firstIndex - secondIndex));
    //             isChanged = false;
    //         }
    //     }
    //     return res;
    // }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
