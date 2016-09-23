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
     *  Time complexity -> O(nlogn), where n is the size of intervals
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return res;
        
        /* sort the collections by ascending order, if start times are the same, compare end times */
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                if (i1.start == i2.start) return i1.end - i2.end;
                else return i1.start - i2.start;
            }    
        });
        
        int start = -1;
        int end = -1;
        
        for (Interval i : intervals) {
            if (start == -1 && end == -1) {
                start = i.start;
                end = i.end;
                continue;
            }
            
            if (i.start > end) {
                res.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            } else {
                end = Math.max(end, i.end);
            }
        }
        
        /* we need to add the final one manually */
        res.add(new Interval(start, end));
        
        return res;
    }
}
