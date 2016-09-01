/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {

    /**
     *  Time complexity -> 1. addNum() -> O(n)
     *                     2. getIntervals -> O(nlogn)
     */

    private List<Interval> res;
    private Set<Integer> set;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        res = new ArrayList<>();
        set = new HashSet<Integer>();
    }
    
    public void addNum(int val) {
        if (set.contains(val)) return;
        
        set.add(val);
        
        // 1. no neighbors
        if (!set.contains(val - 1) && !set.contains(val + 1)) {
            res.add(new Interval(val, val));
        } else if (set.contains(val - 1) && !set.contains(val + 1)) {   // 2. has left neighbor
            for (Interval i : res) {
                if (i.end == val - 1) {
                    i.end = val;
                    break;
                }
            }
        } else if (!set.contains(val - 1) && set.contains(val + 1)) {   // 3. has right neighbor
            for (Interval i : res) {
                if (i.start == val + 1) {
                    i.start = val;
                    break;
                }
            }
        } else {    // 4. has both neighbors
            int start = 0, end = 0;
            Interval delete1 = null, delete2 = null;
            for (Interval i : res) {
                if (i.start == val + 1) {
                    end = i.end;
                    delete1 = i;
                }
                if (i.end == val - 1) {
                    start = i.start;
                    delete2 = i;
                }
            }
            
            res.remove(delete1);
            res.remove(delete2);
            
            res.add(new Interval(start, end));
        }
    }
    
    public List<Interval> getIntervals() {
        Collections.sort(res, (a, b) -> a.start - b.start);
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
