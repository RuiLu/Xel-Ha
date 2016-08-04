/*
 * Pure math problem:
 * The basic idea is to use the property of Bézout's identity and check if z is a multiple of GCD(x, y)
 * Quete from Wiki:
   Bézout's identity (also called Bézout's lemma) is a theorem in the elementary theory of numbers:
   "
   let a and b be nonzero integers and let d be their greatest common divisor. Then there exist integers x
   and y such that ax+by=d

   In addition, the greatest common divisor d is the smallest positive integer that can be written as ax + by

   every integer of the form ax + by is a multiple of the greatest common divisor d.
   "
 *
 */ 
public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z > x + y) return false;
        if (z == x || z == y || z == x + y) return true;
        return z % (GCD(x, y)) == 0;
    }
    
    private int GCD(int x, int y) {
        while (y != 0) {
            int tmp = y;
            y = x % y;
            x = tmp;
        }
        return x;
    }
}
