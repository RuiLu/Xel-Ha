public class Solution {
    /**
     *  Idea -> Hard to describe, see comments.
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public String getPermutation(int n, int k) {
        if (n <= 0) return "";
        
        List<Integer> numbers = new ArrayList<>();  // store numbers from 1 to n.
        int[] factorial = new int[n+1];             // store the factorial sequence.
        StringBuilder sb = new StringBuilder();
        
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = i * factorial[i-1];
            numbers.add(i);
        }
        
        k--;                                        // important to subtract 1 from k, because array is 0-based.
        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n-i];         // get the index of current number.
            sb.append(numbers.get(index));
            numbers.remove(index);                  // remove the number from standby array.
            k -= index * factorial[n-i];            // update the kth number.
        }
        
        return sb.toString();
    }
}
