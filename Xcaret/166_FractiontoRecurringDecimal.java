public class Solution {
    /**
     *  We should change int to long to avoid Integer overflow
     */
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        String sign = (numerator == 0 || numerator < 0 == denominator < 0) ? "" : "-";
        
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        long rem = num % den;
        
        sb.append(sign);
        sb.append(num / den);
        
        if (rem == 0) return sb.toString();
        else sb.append(".");
        
        // key -> num; value -> first appearing position
        Map<Long, Integer> map = new HashMap<>();
        
        while (rem != 0) {
            num = rem * 10;
            
            if (map.containsKey(num)) {
                sb.insert(map.get(num), "(");
                sb.append(")");
                break;
            }
            
            map.put(num, sb.length());
            sb.append(num / den);
            rem = num % den;
        }
        
        return sb.toString();
    }
}
