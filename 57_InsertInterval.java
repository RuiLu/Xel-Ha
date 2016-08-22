/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    /**
     *  O(n), where n is the size of intervals
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int i = 0;
        
        // first, add all intervals whose end time is less than the start time of new interval
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i++));
        }
        
        // second, merge all intervals that are contained in the new interval
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start),
                                      Math.max(intervals.get(i).end, newInterval.end));
            i++;
        }
        res.add(newInterval);
        
        // third, add the remaining intervals
        while (i < intervals.size()) res.add(intervals.get(i++));
        
        return res;
    }
    
    
}
