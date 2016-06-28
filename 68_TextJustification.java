public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> res = new ArrayList<>();
        
        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if ((count + 1 + words[last].length()) > L) break;
                count += words[last].length() + 1;
                last++;
            }
            
            StringBuilder sb = new StringBuilder();
            
            // count the number of words in single line
            int diff = last - index - 1;
            
            // last word or only one word in a single line, left justify
            if (diff == 0 || last == words.length) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i] + " ");
                }
                sb.deleteCharAt(sb.length() - 1);
                for (int i = sb.length(); i < L; i++) {
                    sb.append(" ");
                }
            } else {
                // middle justify
                int space = (L - count) / diff;
                int r = (L - count) % diff;
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    // do not add space after the last word
                    if (i < last - 1) {
                        for (int j = 0; j <= (space + ((i - index) < r ? 1 : 0)); j++) {
                            sb.append(" ");
                        }    
                    }
                }
            }
            res.add(sb.toString());
            index = last;
        }
        return res;
    }
}
