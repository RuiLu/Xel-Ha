/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int buffPtr = 0;    // used to iterate the returned buff array
    private int buffCnt = 0;    // used to store the length of the returned array
    private char[] buff = new char[4];
    
    public int read(char[] buf, int n) {
        int res = 0;
        
        while (res < n) {
            // first call or last call finished
            if (buffPtr == 0) {
                buffCnt = read4(buff);
            }
            
            if (buffCnt == 0) break;
            
            while (res < n && buffPtr < buffCnt) buf[res++] = buff[buffPtr++];
            
            // if buffPtr has traversed the returned array, reset it to 0
            if (buffPtr == buffCnt) buffPtr = 0;
        }
        
        return res;
    }
}
