/**
 *  First -> Use JAVA native Iterator, easy!
 *  Getting idea from -> https://discuss.leetcode.com/topic/24231/short-java-o-1-space
 */ 
public class ZigzagIterator {
    
    private Iterator<Integer> i, j, swap;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i = v1.iterator();
        j = v2.iterator();
    }
    
    public int next() {
        if (i.hasNext()) {
            swap = i;
            i = j;
            j = swap;
        }
        return j.next();
    }
    
    public boolean hasNext() {
        return i.hasNext() || j.hasNext();
    }
} 

/**
 *  Second -> Best! Can be used to solve the follow up
 *        -> Using the properties of LinkedList and Iterator, only need to store iterator from each list
 */
public class ZigzagIterator {
    
    private LinkedList<Iterator> queue;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if (!v1.isEmpty()) queue.offer(v1.iterator());
        if (!v2.isEmpty()) queue.offer(v2.iterator());
    }
    
    public int next() {
        Iterator it = queue.poll();
        int val = (int)it.next();
        if (it.hasNext()) queue.offer(it);
        return val;
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 *  Third -> most simple, using ArrayList, but slow
 */
// public class ZigzagIterator {

//     List<Integer> list;
//     int count;
//     int capacity;

//     public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
//         int i = 0;
//         int m = v1.size();
//         int n = v2.size();
//         list = new ArrayList<>(m + n);
//         count = 0;
//         capacity = m + n;
        
//         for (; i < Math.min(m, n); i++) {
//             list.add(v1.get(i));
//             list.add(v2.get(i));
//         }
        
//         if (m > n) {
//             for (; i < m; i++) list.add(v1.get(i));
//         } else if (m < n) {
//             for (; i < n; i++) list.add(v2.get(i));
//         }
        
//         for (Integer x : list) {
//             System.out.print(x + " ");
//         }    
    
//     }

//     public int next() {
//         return list.get(count - 1);
//     }

//     public boolean hasNext() {
//         count++;
//         if (count <= capacity) return true;
//         else return false;
//     }
// }
/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
