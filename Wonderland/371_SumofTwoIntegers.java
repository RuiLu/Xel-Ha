/*
 * 1. calculate the sum; 2. calculate the carray
 * 3. if the carry equals to 0, then we get the result.
 */
public class Solution {
    public int getSum(int a, int b) {
        if (b == 0) return a;
        int sum = a ^ b; // first calculate the sum
        int carry = (a & b) << 1; // then calculate the carry(进位)
        return getSum(sum, carry);
    }
}
