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
     *  Time complexity -> O(n)
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int i = 0;
        
        /* first, add all intervals whose end time is less than the end time of newInterval */
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i++));
        }
        
        /* second, merge all intervals that are intersected with the newInterval */
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval(Math.min(newInterval.start, intervals.get(i).start),
                                       Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        res.add(newInterval);
        
        /* third, add leftover intervals into res */
        while (i < intervals.size()) res.add(intervals.get(i++));
        
        return res;
    }
}
