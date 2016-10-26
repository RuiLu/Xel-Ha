public class SnakeGame {
    /**
     *  Idea -> Using a doubled-link list to represent the snake
     *          and using a set to store the snake's body to check if snake hits itself
     */
    private ListNode fakeHead = null;
    private ListNode fakeTail = null;
    private Set<Integer> body = new HashSet<Integer>();
    private Deque<Integer> foods = new ArrayDeque<Integer>();
    private int width = 0;
    private int height = 0;
    private int length = 0;
    
    class ListNode {
        ListNode next = null;
        ListNode prev = null;
        int val = 0;
        
        public ListNode(int val) {
            this.val = val;
        }
    }

    private void addHead(ListNode head) {
        head.next = fakeHead.next;
        head.prev = fakeHead;
        
        fakeHead.next.prev = head;
        fakeHead.next = head;
    }
    
    private void deleteTail() {
        fakeTail.prev.prev.next = fakeTail;
        fakeTail.prev = fakeTail.prev.prev;
    }
    
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        body.add(0);
        
        fakeHead = new ListNode(-1);
        fakeTail = new ListNode(-1);
        
        fakeHead.next = fakeTail;
        fakeTail.prev = fakeHead;
        
        // initial position
        addHead(new ListNode(0));
        body.add(0);
        
        for (int[] f : food) {
            foods.offer(f[0] * width + f[1]);
        }
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        ListNode currNode = fakeHead.next;
        int x = currNode.val / width;
        int y = currNode.val % width;
        
        switch (direction) {
            case "U":
                x--;
                break;
            case "L":
                y--;
                break;
            case "R":
                y++;
                break;
            case "D":
                x++;
                break;
        }
    
        int val = x * width + y;
    
        if (x < 0 || y < 0 || x >= height || y >= width) return -1;
        
        if (!foods.isEmpty() && foods.peek() == val) {
            addHead(new ListNode(val));
            body.add(val);
            foods.poll();
            length++;
            return length;
        }
        
        body.remove(fakeTail.prev.val);
        int deletedVal = fakeTail.prev.val;
        deleteTail();
        if (body.contains(val)) return -1;
        
        addHead(new ListNode(val));
        body.add(val);
        
        return length;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
