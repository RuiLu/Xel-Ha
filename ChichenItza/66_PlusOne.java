public class Solution {
    /**
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return new int[0];
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = carry + digits[i];
            carry = digits[i] / 10;
            digits[i] = digits[i] % 10;
        }
        if (carry == 0) {
            return digits;
        } else {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            for (int i = 0; i < digits.length; i++) res[i+1] = digits[i];
            return res;
        }
    }
}
