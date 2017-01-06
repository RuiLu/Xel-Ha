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
     *  Time complexity -> O(nlogn)
     *  Space complexity -> O(1)
     */ 
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return list;
        
        /* Sort intervals according to their start times */
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                if (i1.start == i2.start) return i1.end - i2.end;
                else return i1.start - i2.start;
            }
        });
        
        /* Connect intervals one by one */
        for (int i = 0; i < intervals.size(); i++) {
            Interval newInterval = intervals.get(i);
            /* Pay attention to the condition here */
            while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
                i++;
            }
            i--;
            list.add(newInterval);
        }
        
        return list;
    }
}
