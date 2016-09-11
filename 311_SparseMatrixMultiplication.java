public class Solution {
    /**
     *  Without table, most naive way
     */
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = B.length, l = B[0].length;
        int[][] res = new int[m][l];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < l; k++) {
                        if (B[j][k] != 0) res[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
        
        return res;
    }
    
    /**
     *  With one table
     */
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) return null;
        
        int m = A.length;
        int n = A[0].length;
        int l = B[0].length;
        int[][] res = new int[m][l];
        
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
            for (int j = 0; j < l; j++) {
                if (B[i][j] != 0) map.get(i).put(j, B[i][j]);
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
