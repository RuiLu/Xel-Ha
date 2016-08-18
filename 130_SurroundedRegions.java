public class Solution {
    
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        
        int row = board.length;
        int col = board[0].length;
        
        // first -> fill 'O' on the border with '#'
        // 1. first row and last row
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') bfs_fill(board, 0, i, row, col);
            if (board[row-1][i] == 'O') bfs_fill(board, row-1, i, row, col);
        }
        
        // 2. firsr column and last column
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') bfs_fill(board, i, 0, row, col);
            if (board[i][col-1] == 'O') bfs_fill(board, i, col-1, row, col);
        }
        
        // second -> traverse the matrix, turn 'O' into 'X', turn '#' back to 'O'
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '#') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    
    private void bfs_fill(char[][] board, int i, int j, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        
        board[i][j] = '#';
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];
            
            if (x > 0 && board[x-1][y] == 'O') {
                queue.offer(new int[]{x-1, y});
                board[x-1][y] = '#';
            }
            if (x < row-1 && board[x+1][y] == 'O') {
                queue.offer(new int[]{x+1, y});
                board[x+1][y] = '#';
            }
            if (y > 0 && board[x][y-1] == 'O') {
                queue.offer(new int[]{x, y-1});
                board[x][y-1] = '#';
            }
            if (y < col-1 && board[x][y+1] == 'O') {
                queue.offer(new int[]{x, y+1});
                board[x][y+1] = '#';
            }
        }
    }
    
}
