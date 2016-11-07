// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    
    /**
     *  Idea 1 -> Use another Iterator directly
     */
    private static Iterator<Integer> ii = null;
    private static Integer peek = null;
     
    public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    ii = iterator;
	    if (ii.hasNext()) {
	        peek = ii.next();
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer value = peek;
	    peek = ii.hasNext() ? ii.next() : null;
	    return value;
	}

	@Override
	public boolean hasNext() {
	    return peek != null;
	}
    
    /**
     *  Idea 2 -> Use a ListIterator
     */
    private static ListIterator<Integer> li = null;
    private static List<Integer> list = null;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    list = new ArrayList<>();
	    while (iterator.hasNext()) {
	        list.add(iterator.next());
	    }
	    li = list.listIterator();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        Integer value = li.next();
        li.previous();
        return value;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return li.next();
	}

	@Override
	public boolean hasNext() {
	    return li.hasNext();
	}
}
