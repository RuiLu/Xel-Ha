public class Solution {
    public int[] countBits(int num) {
    
        int[] res = new int[num + 1];
        if (num <= 0) return res;
        
        int pow = 1;
        for (int i = 1, index = 0; i <= num; i++, index++) {
            if (i == pow) {
                pow *= 2;
                index = 0;
            }
            res[i] = res[index] + 1;
        }
       
       return res;
    }
}
