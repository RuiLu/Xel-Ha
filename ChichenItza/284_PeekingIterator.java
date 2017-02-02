// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    /**
     * Idea -> Directly using Iterator
     * Time complexity -> O(1) for all methods
     * Space complexity -> O(1)
     */
    private Iterator<Integer> iterator;
    private Integer peek;
    
    public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    peek = null;
	    this.iterator = iterator;
	    
	    /* first assign the first element to peek */
	    if (iterator.hasNext()) peek = iterator.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    /* return the old peek */
	    Integer old = peek;
	    /* if there exists next, move iterator to next and assign next's value to peek,
	     * otherwise, assign null to peek, meaning there is no next. */
	    if (iterator.hasNext()) peek = iterator.next();
	    else peek = null;
	    return old;
	}

	@Override
	public boolean hasNext() {
	    /* if peek is null, meaning that there is no next existing. */
	    return peek != null;
	}


    /**
     * Idea -> Maintiain a Queue
     * Time complexity -> O(n) for constructor
     *                    O(1) for other methods.
     * Space complexity -> O(n)
     */
    private Queue<Integer> queue;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    queue = new LinkedList<>();
	    while (iterator.hasNext()) queue.offer(iterator.next());
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (queue.isEmpty()) return 0;
        return queue.peek();
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (queue.isEmpty()) return 0;
	    return queue.poll();
	}

	@Override
	public boolean hasNext() {
	    return !queue.isEmpty();
	}
}
