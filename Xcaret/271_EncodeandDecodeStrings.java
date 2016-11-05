public class Codec {
    /**
     *  Idea -> Encode string in format of +len+string, e.x. "+1+a+2+ab..."
     */
     
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            int len = str.length();
            sb.append("+" + len + "+" + str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        
        int index = 0;
        
        while (index < s.length()) {
            int first = s.indexOf("+", index);
            int second = s.indexOf("+", index + 1);
            int len = Integer.parseInt(s.substring(first + 1, second));
            
            String str = s.substring(second + 1, second + 1 + len);
            res.add(str);
            
            index = second + 1 + len;
        }
        
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
