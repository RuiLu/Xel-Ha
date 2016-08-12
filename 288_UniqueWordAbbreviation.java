public class ValidWordAbbr {

    // 1. very slow
    // private HashMap<String, HashSet<String>> map;

    // public ValidWordAbbr(String[] dictionary) {
    //     map = new HashMap<String, HashSet<String>>();
        
    //     for (String word : dictionary) {
    //         if (word.length() > 2) {
    //             String key = word.substring(0, 1) + Integer.toString(word.length() - 2) + word.substring(word.length() - 1);
    //             if (!map.containsKey(key)) {
    //                 HashSet<String> set = new HashSet<>();
    //                 set.add(word);
    //                 map.put(key, set);
    //             } else {
    //                 map.get(key).add(word);
    //             }
    //         }
    //     }
    // }

    // public boolean isUnique(String word) {
    //     if (word == null) return false;
    //     if (word.length() <= 2) return true;
        
    //     String preAndSuffix = word.substring(0, 1) + Integer.toString(word.length() - 2) + word.substring(word.length() - 1);
        
    //     if (map.containsKey(preAndSuffix)) {
    //         if (map.get(preAndSuffix).size() > 1) {
    //             return false;
    //         } else {
    //             if (map.get(preAndSuffix).contains(word)) return true;
    //             return false;
    //         }
    //     }
    //     else {
    //         return true;
    //     }
    // }
    
    // 2. Same thought, but much faster!!
    private HashMap<String, String> map;
    
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String, String>();
        
        for (String word : dictionary) {
            String key = this.getKey(word);
            if (map.containsKey(key)) {
                if (!map.get(key).equals(word)) {
                    map.put(key, "");
                }
            } else {
                map.put(key, word);
            }
        }
    }
    
    public boolean isUnique(String word) {
        String key = getKey(word);
        return !map.containsKey(key) || map.get(key).equals(word);
    }
    
    private String getKey(String word) {
        if (word.length() <= 2) return word;
        else return word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1);
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
