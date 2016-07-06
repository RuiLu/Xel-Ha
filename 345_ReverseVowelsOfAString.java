public class Solution {
    public String reverseVowels(String s) {
        
        char[] ch = s.toCharArray();
        int head = 0, tail = s.length() - 1;
        
        boolean shouldEnd = false;
        
        while (head < tail) {
            while (ch[head] != 'a' && ch[head] != 'e' && ch[head] != 'i' && ch[head] != 'o' && ch[head] != 'u' &&
                   ch[head] != 'A' && ch[head] != 'E' && ch[head] != 'I' && ch[head] != 'O' && ch[head] != 'U') {
                
                head++;
                if (head >= tail) {
                    shouldEnd = true;
                    break;
                }
            }
                   
            if (shouldEnd) break;
                   
            while (ch[tail] != 'a' && ch[tail] != 'e' && ch[tail] != 'i' && ch[tail] != 'o' && ch[tail] != 'u' &&
                   ch[tail] != 'A' && ch[tail] != 'E' && ch[tail] != 'I' && ch[tail] != 'O' && ch[tail] != 'U') {
                
                tail--;
                if (head >= tail) {
                    shouldEnd = true;
                    break;
                }
            }
                
            if (shouldEnd) break;
               
            char tmp = ch[head];
            ch[head] = ch[tail];
            ch[tail] = tmp;
            
            head++;
            tail--;
        }
        
        return new String(ch);    
    }
}
