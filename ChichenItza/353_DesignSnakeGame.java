public class SnakeGame {

    private Deque<Integer> body;
    private Set<Integer> bodySet;
    private Queue<Integer> foods;
    private int row;
    private int col;
    private int score;
    private int i;
    private int j;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        body = new ArrayDeque<>();
        bodySet = new HashSet<>();
        foods = new LinkedList<>();
        row = height;
        col = width;
        score = 0;
        i = 0;
        j = 0;
        
        // add its initial position to body
        body.offerFirst(0);
        bodySet.add(0);
        
        // add all the food to foods
        for (int i = 0; i < food.length; i++) {
            foods.offer(food[i][0]*col+food[i][1]);
        }
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        switch (direction) {
            case "U":
                i--;
                break;
            case "L":
                j--;
                break;
            case "R":
                j++;
                break;
            case "D":
                i++;
                break;
            default:
                break;
        }
        
        int id = i*col+j;
        
        // The sequence of cases is IMPORTANT!!
        // case 1 - hit wall
        if (i < 0 || j < 0 || i >= row || j >= col) return -1;
        
        // case 2 - hit food
        if (!foods.isEmpty() && foods.peek() == id) {
            // take food out from foods inventory
            foods.poll();
            // add score by one
            score++;
            // add this position to body
            body.offerFirst(id);
            bodySet.add(id);
        } else {
            // first remove tail
            bodySet.remove(body.pollLast());
            
            // case 3 - hit itself
            if (bodySet.contains(id)) return -1;
            
            // case 4 - hit nothing, update body
            body.offerFirst(id);
            bodySet.add(id);
        }
        
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
