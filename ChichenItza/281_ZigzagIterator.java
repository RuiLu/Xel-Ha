public class ZigzagIterator {
    /**
     *  Idea -> Create a Queue<ListIterator<Integer>>, storing all ListIterator of all lists
     */
    private Queue<ListIterator<Integer>> queue;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if (v1 != null && v1.size() > 0) queue.offer(v1.listIterator());
        if (v2 != null && v2.size() > 0) queue.offer(v2.listIterator());
    }

    public int next() {
        if (queue.isEmpty()) return 0;
        ListIterator<Integer> li = queue.poll();
        int value = li.next();
        /* Only if the current list has following elements, we add its listIterator back to the queue */
        if (li.hasNext()) queue.offer(li);
        return value;
    }

    public boolean hasNext() {
        if (queue.isEmpty()) return false;
        return queue.peek().hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
