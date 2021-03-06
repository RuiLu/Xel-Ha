public class Solution {
    /**
     *  The following final parameters are referred from ->
     *  https://discuss.leetcode.com/topic/30488/short-clean-java-solution
     */
    private final String[] BELOWTWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        
        String res = "";
        int i = 0;
        
        while (num > 0) {
            if (num % 1000 != 0) {
                res = helper(num % 1000) + THOUSANDS[i] + " " + res;
            }
            num /= 1000;
            i++;
        }
        
        return res.trim();
    }
    
    private String helper(int num) {
        if (num == 0) return "";
        else if (num < 20) return BELOWTWENTY[num] + " ";
        else if (num < 100) return TENS[num / 10] + " " + helper(num % 10);
        else return BELOWTWENTY[num / 100] + " Hundred " + helper(num % 100);
    }
}

public class Solution {
    /**
     *  The following final parameters are referred from ->
     *  https://discuss.leetcode.com/topic/30488/short-clean-java-solution
     */
    private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    
    public String numberToWords(int num) {
        if (num < 0) return "";
        if (num == 0) return "Zero";
        return helper(num);
    }
    
    private String helper(int num) {
        String res = "";
        if (num < 10) res = belowTen[num];
        else if (num < 20) res = belowTwenty[num - 10];
        else if (num < 100) res = belowHundred[num / 10] + " " + helper(num % 10);
        else if (num < 1000) res = helper(num / 100) + " Hundred " + helper(num % 100);
        else if (num < 1000000) res = helper(num / 1000) + " Thousand " + helper(num % 1000);
        else if (num < 1000000000) res = helper(num / 1000000) + " Million " + helper(num % 1000000);
        else res = helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
        return res.trim();
    }
}
