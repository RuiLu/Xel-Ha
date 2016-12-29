public class Solution {
    /**
     *  Calculate the key by creating the shift offset
     *  Time complexity -> O(n*len), where n is the length of strings, len is the average length of string in strings
     */
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings == null || strings.length == 0) return res;
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strings) {
            char first = str.charAt(0);
            StringBuilder sb = new StringBuilder();
            for (char next : str.toCharArray()) {
                int offset = (next - first) < 0 ? (next - first + 26) : (next - first);
                sb.append(offset + " ");
            }
            if (!map.containsKey(sb.toString())) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sb.toString(), list);
            } else {
                map.get(sb.toString()).add(str);
            }
        }
        
        for (String key : map.keySet()) res.add(map.get(key));
        
        return res;
    }
}
