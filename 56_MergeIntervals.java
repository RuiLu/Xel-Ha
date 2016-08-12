/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 
/**
 *  Use interface Comparator, and implement compare() function to realize comparator
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return res;
        if (intervals.size() == 1) return intervals;
        
        Collections.sort(intervals, new IntervalComparator());
        
        Interval prev = intervals.get(0);
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            
            if (prev.end >= curr.start) {
                Interval merge = new Interval(prev.start, Math.max(prev.end, curr.end));
                prev = merge;
            } else {
                res.add(prev);
                prev = curr;
            }
        }
        
        res.add(prev);
        
        return res;
    }
    
    class IntervalComparator implements Comparator<Interval> {
        
        @Override 
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
        
    }
}
