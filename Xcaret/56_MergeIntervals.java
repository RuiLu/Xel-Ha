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
        
        /* Sort intervals according to their start times */
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                if (i1.start == i2.start) return i1.end - i2.end;
                else return i1.start - i2.start;
            }
        });
        
        int index = 0;
        while (index < intervals.size() - 1) {
            int start = intervals.get(index).start;
            int end = intervals.get(index).end;
            
            while (index < intervals.size() && intervals.get(index).start <= end) {
                end = Math.max(end, intervals.get(index).end);
                index++;
            }
            
            res.add(new Interval(start, end));
        }
        
        /* if index < intervals.size(), means that we have not considered last interval yet. 
           So we need to add the last interval manually. */
        if (index < intervals.size()) res.add(intervals.get(index));
        
        return res;
    }
}
