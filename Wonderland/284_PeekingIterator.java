// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
/**
 *  First method -> directly use the property of Iterator
 */ 
class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iter; // should assign Integer as Object 
    private Integer peek = null; // allowed to be null
        
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
	    if (iter.hasNext()) {
	        peek = iter.next();
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
	    Integer val = peek;
	    peek = iter.hasNext() ? iter.next() : null;
	    return val;
	}

	@Override
	public boolean hasNext() {
	    return peek != null;
	}
}

/**
 *  Second method -> use a linked-list to do iteration
 */
class PeekingIterator implements Iterator<Integer> {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    
    private ListNode head = null;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    ListNode prev = null;
	    while (iterator.hasNext()) {
	        if (head == null) {
	            head = new ListNode(iterator.next());
	            prev = head;
	        } else {
	            ListNode node = new ListNode(iterator.next());
	            prev.next = node;
	            prev = node;
	        }
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return head.val;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (head != null) {
	        Integer val = head.val;
	        head = head.next;
	        return val;
	    }
	    return null;
	}

	@Override
	public boolean hasNext() {
	    return head != null;
	}
}
