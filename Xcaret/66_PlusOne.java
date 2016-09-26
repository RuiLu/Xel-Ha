public class Solution {
    /**
     *  Actually, no need for stack
     */
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;
        
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = carry + digits[i];
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        
        if (carry == 0) {
            return digits;
        } else {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                res[i+1] = digits[i];
            }
            return res;
        }
    } 
     
    /**
     *  Using a Stack, Time complexity -> O(n)
     */
    // public int[] plusOne(int[] digits) {
        // if (digits == null || digits.length == 0) return digits;
        
        // Stack<Integer> stack = new Stack<>();
        // int carry = 1;
        
        // for (int i = digits.length-1; i >= 0; i--) {
        //     int sum = carry + digits[i];
        //     stack.push(sum % 10);
        //     carry = sum / 10;
        // }
        
        // if (carry != 0) stack.push(carry);
        
        // int i = 0;
        // if (stack.size() == digits.length) {
        //     while (!stack.isEmpty()) {
        //         digits[i++] = stack.pop();
        //     }
        //     return digits;
        // } else {
        //     int[] res = new int[digits.length+1];
        //     while (!stack.isEmpty()) {
        //         res[i++] = stack.pop();
        //     }
        //     return res;
        // }
    // }
}
