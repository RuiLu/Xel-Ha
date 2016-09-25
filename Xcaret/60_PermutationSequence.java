public class Solution {
    /**
     *  Reference -> https://discuss.leetcode.com/topic/17348/explain-like-i-m-five-java-solution-in-o-n/2
     *  Time complexity -> O(n)
     */
    public String getPermutation(int n, int k) {
        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int[] factorial = new int[n+1];
        
        /* create an array for factorial number look-up */
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i-1] * i;
            
            /* create a list of numbers to get indices */
            numbers.add(i);
        }
        
        k--;
        
        for (int i = 1; i <= n; i++) {
            int index = k/factorial[n-i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k -= index * factorial[n-i];
        }
        
        return sb.toString();
    }
    
    /**
     *  Backtracking, has to retrieve all permutations
     *  Time Limit Exceeded
     */
    // public String getPermutation(int n, int k) {
    //     List<String> strs = new ArrayList<>();
    //     helper(strs, n, new boolean[n+1], new ArrayList<Integer>());
    //     return k > strs.size() ? "" : strs.get(k - 1);
    // }
    
    // private void helper(List<String> strs, int n, boolean[] visited, List<Integer> tmp) {
    //     if (tmp.size() == n) {
    //         StringBuilder sb = new StringBuilder();
    //         for (int i : tmp) sb.append(i);
    //         strs.add(sb.toString());
    //         return;
    //     }
        
    //     for (int i = 1; i <= n; i++) {
    //         if (!visited[i]) {
    //             visited[i] = true;
    //             tmp.add(i);
    //             helper(strs, n, visited, tmp);
    //             tmp.remove(tmp.size() - 1);
    //             visited[i] = false;
    //         }
    //     }
    // }
}
