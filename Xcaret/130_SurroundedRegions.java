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
    private int[] unionSet = null;
    private boolean[] edgeConnected = null;
    
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        
        int row = board.length;
        int col = board[0].length;
        
        unionSet = new int[row*col];
        for (int i = 0; i < unionSet.length; i++) {
            unionSet[i] = i;
        }
        
        edgeConnected = new boolean[row*col];
        for (int i = 0; i < edgeConnected.length; i++) {
            int x = i / col;
            int y = i % col;
            edgeConnected[i] = (board[x][y] == 'O' && (x == 0 || y == 0 || x == row - 1 || y == col - 1));
        }
        
        // union-find, to connect all 'O's that has a connection to edge
        for (int i = 0; i < unionSet.length; i++) {
            int x = i / col;
            int y = i % col;
            int up = x - 1;
            int right = y + 1;
            if (up >= 0 && board[x][y] == board[up][y]) union(i, i - col);
            if (right < col && board[x][y] == board[x][right]) union(i, i + 1);
        }
        
        // if the id of connected zone is the one that connected to the edge, then we don't change it
        for (int i = 0; i < unionSet.length; i++) {
            int x = i / col;
            int y = i % col;
            if (!edgeConnected[find(i)] && board[x][y] == 'O') {
                board[x][y] = 'X';
            }
        }
    }
    
    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        boolean edgeC = edgeConnected[rootX] || edgeConnected[rootY];
        unionSet[rootX] = rootY;
        edgeConnected[rootY] = edgeC;
    }
    
    private int find(int id) {
        if (unionSet[id] == id) return id;
        unionSet[id] = find(unionSet[id]);
        return unionSet[id];
    }
}
