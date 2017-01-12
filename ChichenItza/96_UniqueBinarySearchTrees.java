public class Solution {
    /**
     * Idea -> Dynamic programming
     *         G(n): the number of unique BST for a sequence of length n.
     *         F(i, n), 1 <= i <= n: the number of unique BST, where the number i is the root of BST, and the sequence ranges from 1 to n.
     *         G(n) = F(1, n)+F(2, n)+...+F(n, n)
     *         F(i, n) = G(i-1)*G(n-i)
     *         G(n) = G(0)*G(n-1)+G(1)*G(n-2)+...+G(n-1)*G(0)    
     * Reference -> https://discuss.leetcode.com/topic/8398/dp-solution-in-6-lines-with-explanation-f-i-n-g-i-1-g-n-i
     * Time complexity -> O(n^2)
     */
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j-1] * G[i-j];
            }
        }
        
        return G[n];
    }
}
