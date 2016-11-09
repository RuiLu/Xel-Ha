public class Solution {
    /**
     *  Idea -> Uas HashMap to keep track of non-zero elements in B.
     *  Time complexity -> O(mnl), in worst case
     */
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int l = B[0].length;
        int[][] res = new int[m][l];
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        for (int j = 0; j < n; j++) {
            map.put(j, new HashMap<>());
            for (int k = 0; k < l; k++) {
                if (B[j][k] != 0) {
                    map.get(j).put(k, B[j][k]);
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    for (int k : map.get(j).keySet()) {
                        res[i][k] += A[i][j] * map.get(j).get(k);
                    }
                }
            }
        }
        
        return res;
    }
}
