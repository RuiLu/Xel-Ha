public class Vector2D implements Iterator<Integer> {
    
    /**
     *  With two iterators
     */
    private Iterator<List<Integer>> master;
    private Iterator<Integer> child = null;
    
    public Vector2D(List<List<Integer>> vec2d) {
        master = vec2d.iterator();
        if (master.hasNext()) {
            child = master.next().iterator();
        }
    }
    
    public Integer next() {
        return child.next();
    }
    
    public boolean hasNext() {
        if (child != null) {
            if (child.hasNext()) return true;
            
            if (master.hasNext()) {
                child = master.next().iterator();
                return hasNext();
            }
        }
        
        return false;
    }
    
    /**
     *  Queue
     */
    private Deque<ListIterator<Integer>> queue;

    public Vector2D(List<List<Integer>> vec2d) {
        queue = new ArrayDeque<>();
        for (int i = 0; i < vec2d.size(); i++) {
            queue.offer(vec2d.get(i).listIterator());
        }
    }

    @Override
    public Integer next() {
        return queue.getFirst().next();
    }

    @Override
    public boolean hasNext() {
        while (!queue.isEmpty()) {
            if (queue.getFirst().hasNext()) return true;
            queue.poll();
        }
        
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
