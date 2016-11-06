public class ZigzagIterator {
    /**
     *  Idea -> Maintain ListIterators for each List<Integer> in a Queue,
     *          Take the first out, get its value, then put it back to the tail if it hasNext() is true
     *  Time complexity -> O(1)
     */
    private Queue<ListIterator<Integer>> queue = null;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        ListIterator<Integer> li1 = null;
        ListIterator<Integer> li2 = null;
        if (v1.size() > 0) {
            li1 = v1.listIterator();
            queue.offer(li1);
        }
        if (v2.size() > 0) {
            li2 = v2.listIterator();
            queue.offer(li2);
        }
    }

    public int next() {
        if (queue.isEmpty()) return 0;
        ListIterator<Integer> curr = queue.poll();
        int value = curr.next();
        if (curr.hasNext()) {
            queue.offer(curr);
        }
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
