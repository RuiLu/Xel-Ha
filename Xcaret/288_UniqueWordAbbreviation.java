public class ValidWordAbbr {
    /**
     *  Idea -> This is a easy question, but we need to consider various kinds of situations
     */
    private static Map<String, String> map = null;

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for (String word : dictionary) {
            String key = getKey(word);
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

    private static String getKey(String word) {
        if (word.length() <= 2) return word;
        return word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1);
    } 
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
