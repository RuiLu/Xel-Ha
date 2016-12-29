/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buff = new char[4];
        int res = 0;
        
        while (res < n) {
            int count = read4(buff);
            if (count == 0) break;
            
            for (int i = 0; i < count; i++) {
               if (res < n) buf[res++] = buff[i];
            }
        }
        
        return res;
    }
}
