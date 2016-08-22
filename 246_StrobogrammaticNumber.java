public class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) return false;
        
        int len = num.length();
        int left = 0, right = len - 1;
        
        while (left < right) {
            int leftNum = num.charAt(left) - '0';
            int rightNum = num.charAt(right) - '0';
            if ((leftNum == 6 && rightNum == 9) || (leftNum == 9 && rightNum == 6) ||
                (leftNum == 8 && rightNum == 8) || (leftNum == 1 && rightNum == 1) ||
                (leftNum == 0 && rightNum == 0)) {
                    left++;
                    right--;
                }
            else return false;
        }
        
        if (len % 2 == 0) return true;
        else {
            int mid = num.charAt(left) - '0';
            if (mid == 1 || mid == 8 || mid == 0) return true;
            else return false;
        }
        
    }
}

