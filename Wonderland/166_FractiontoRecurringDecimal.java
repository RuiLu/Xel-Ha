public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        
        String sign = (numerator == 0 || numerator < 0 == denominator < 0) ? "" : "-";
        
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        sb.append(sign);
        sb.append(num / den);
        
        long remainder = num % den;
        if (remainder == 0) return sb.toString();
        
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        
        while (!map.containsKey(remainder)) {
            map.put(remainder, sb.length());
            sb.append(10 * remainder / den);
            remainder = 10 * remainder % den;
        }
        
        int index = map.get(remainder);
        sb.insert(index, "(");
        sb.append(")");
        
        return sb.toString().replace("(0)", "");
    }
}
