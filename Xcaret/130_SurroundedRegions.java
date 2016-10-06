public class Solution {
    /**
     *  Idea -> Turn all 'O' on edges into '1', 
     *          then traverse the matrix and turn other 'O's into 'X', meanwhile, turn '1' back into 'O'
     *          If we use DFS here, it will encounter 'Memory Limit Exceeded'
     *          So we use BFS here.
     *  Time complexity -> O(mn)
     *  Space complexity -> O
     */
    private int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
     
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        
        int row = board.length;
        int col = board[0].length;
        
        // fill connected 'O's, which located on edges, with '1' 
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') fill(board, i, 0);
            if (board[i][col-1] =='O') fill(board, i, col-1);
        }
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') fill(board, 0, j);
            if (board[row-1][j] == 'O') fill(board, row-1, j);
        }
        
        // turn remained 'O' into 'X', and turn '1' into 'O'
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '1') board[i][j] = 'O';
            }
        }
    }
    
    private void fill(char[][] board, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        
        board[i][j] = '1';
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) continue;
                if (board[x][y] == 'O') {
                    board[x][y] = '1';
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }
    
    /**
     *  Idea -> Union find
     *          Using a boolean[] to indicate whether a 'O' has connected to a edge 'O'
     */
    private boolean[] edgeConnected = null;
    private int[] unionSet = null;
     
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        
        int row = board.length;
        int col = board[0].length;
        
        edgeConnected = new boolean[row*col];
        unionSet = new int[row*col];
        
        for (int i = 0; i < unionSet.length; i++) {
            unionSet[i] = i;
        }
        
        for (int i = 0; i < edgeConnected.length; i++) {
            int x = i / col;
            int y = i % col;
            edgeConnected[i] = (board[x][y] == 'O' && (x == 0 || y == 0 || x == row-1 || y == col-1));
        }
        
        for (int i = 0; i < unionSet.length; i++) {
            int x = i / col;
            int y = i % col;
            int up = x - 1;
            int right = y + 1;
            if (up >= 0 && board[up][y] == board[x][y]) union(i, i-col);
            if (right < col && board[x][right] == board[x][y]) union(i, i+1);
        }
        
        for (int i = 0; i < edgeConnected.length; i++) {
            int x = i / col;
            int y = i % col;
            if (!edgeConnected[find(i)] && board[x][y] == 'O') board[x][y] = 'X';
        }
    }
    
    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        
        boolean edgeC = edgeConnected[rootI] || edgeConnected[rootJ];
        unionSet[rootI] = rootJ;
        edgeConnected[rootJ] = edgeC;
    }
    
    private int find(int id) {
        if (unionSet[id] == id) return id;
        unionSet[id] = find(unionSet[id]);
        return unionSet[id];
    }
}
