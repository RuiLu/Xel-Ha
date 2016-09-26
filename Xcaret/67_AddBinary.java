public class Solution {
    /**
     *  Time complexity -> O(n)
     */
    public String addBinary(String a, String b) {
        char[] aca = a.toCharArray();
        char[] bca = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        
        for (int i = aca.length-1, j = bca.length-1; i >= 0 || j >= 0; i--, j--) {
            int sum = carry;
            if (i >= 0) sum += aca[i] - '0';
            if (j >= 0) sum += bca[j] - '0';
            carry = sum / 2;
            sb.append(sum % 2);
        }
        
        if (carry != 0) sb.append(1);
        
        return sb.reverse().toString();
    }
}
