public class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    private Queue<int[]> foodPos;
    private LinkedList<int[]> snakePos;
    private Set<Integer> snakeBody;
    private int row;
    private int col;
    private int foodCount;
    
    public SnakeGame(int width, int height, int[][] food) {
        row = height;
        col = width;
        foodPos = new LinkedList<>();
        snakePos = new LinkedList<>();
        snakeBody = new HashSet<>();
        foodCount = 0;
        
        for (int i = 0; i < food.length; i++) foodPos.offer(food[i]);
        
        snakePos.addLast(new int[]{0, 0});
        snakeBody.add(0);
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int res = 0;
        int nextI = snakePos.getLast()[0], nextJ = snakePos.getLast()[1];
        switch(direction) {
            case "U":
                nextI--;
                res = getMoveResult(nextI, nextJ);
                break;
            case "L":
                nextJ--;
                res = getMoveResult(nextI, nextJ);
                break;
            case "R":
                nextJ++;
                res = getMoveResult(nextI, nextJ);
                break;
            case "D":
                nextI++;
                res = getMoveResult(nextI, nextJ);
                break;
            default:
                break;
        }
        return res;
    }
    
    private int getMoveResult(int i, int j) {
        // died
        if (i < 0 || j < 0 || i >= row || j >= col) {
            return -1;
        } else {
            // 1. next spot contains food
            if (!foodPos.isEmpty() && i == foodPos.peek()[0] && j == foodPos.peek()[1]) {
                // determin whether snake hits itself
                int pos = i * col + j;
                if (snakeBody.contains(pos)) return -1;
                
                // update new position
                snakePos.addLast(new int[]{i, j});
                snakeBody.add(pos);
                
                foodPos.poll();
                return ++foodCount;
            } else { // 2. next spot contains no food
                // remove the last snake body
                int[] lastPos = snakePos.poll();
                snakeBody.remove(lastPos[0] * col + lastPos[1]);
                
                // determin whether snake hits itself
                int pos = i * col + j;
                if (snakeBody.contains(pos)) return -1;
                
                // update new position
                snakePos.addLast(new int[]{i, j});
                snakeBody.add(pos);
                
                return foodCount;
            }
            
        }
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
