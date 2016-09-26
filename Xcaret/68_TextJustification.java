public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        
        int wordCount = 0;
        int wordLength = 0;
        int totalLength = 0;
        
        for (int i = 0; i < words.length; ) {
            if (wordCount == 0) {
                totalLength += words[i].length();
            } else {
                /* for single whitespace */
                totalLength += 1;   
                totalLength += words[i].length();
            }
            
            if (totalLength > maxWidth) {
                if (wordCount == 1) {
                    /* 1. only contains one word */
                    StringBuilder sb = new StringBuilder();
                    sb.append(words[i-1]);
                    int whitespaceNum = maxWidth - wordLength;
                    while (whitespaceNum-- > 0) {
                        sb.append(" ");
                    }
                    res.add(sb.toString());
                    
                } else {
                    /* 2. count the number of whitespace */
                    int whitespaceNum = maxWidth - wordLength;
                    int spaceCount = wordCount - 1;
                    int space = whitespaceNum / spaceCount;
                    int remainder = whitespaceNum % spaceCount;
                    
                    /* 3. contructing string */
                    StringBuilder sb = new StringBuilder();
                    int start = i - wordCount;
                    for (int j = start; j < i; j++) {
                        sb.append(words[j]);
                        if (j == i - 1) {
                            break;
                        } else {
                            /* 4. middle justify, which is the most important and tricky one */
                            for (int k = 1; k <= (space + ((j - start) < remainder ? 1 : 0)); k++) {
                                sb.append(" ");
                            }
                        }
                    }
                    
                    res.add(sb.toString());
                }
                /* 5. reset basic parameters */
                wordCount = 0;
                wordLength = 0;
                totalLength = 0;
            } else {
                wordCount++;
                wordLength += words[i].length();
                i++;
                
                /* when meeting the last line */
                if (i == words.length) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = i - wordCount; j < i; j++) {
                        sb.append(words[j] + " ");
                    }
                    if (sb.length() <= maxWidth) {
                        int diff = maxWidth - sb.length();
                        while (diff-- > 0) {
                            sb.append(" ");
                        }
                    } else {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    res.add(sb.toString());
                }
            }
        }
        
        return res;
    }
}
