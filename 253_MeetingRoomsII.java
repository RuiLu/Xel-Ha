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
     * First thought -> Take apart start and end times, distinguishing them by true and false.
     *                  Then calculateing the maximum overlap
     * Slow and not so concise
     */ 
    class TimeRecord {
        int time;
        boolean isStart;
        
        public TimeRecord(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }
    
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        if (intervals.length == 1) return 1;
        
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        LinkedList<TimeRecord> list = new LinkedList<>(); 
        
        for (Interval interval : intervals) {
            list.add(new TimeRecord(interval.start, true));
            list.add(new TimeRecord(interval.end, false));
        }
        
        Collections.sort(list, (a, b) -> a.time - b.time); // ascending order
        
        int res = Integer.MIN_VALUE;
        int count = 0;
        
        for (TimeRecord tr : list) {
            if (tr.isStart) count++;
            else count--;
            res = Math.max(res, count);
        }
        
        return res;
    }
    
    /**
     *  Second thought -> Use minHeap, and sort them by end time.
     *                    Then calculate the size of priorityqueue at each time, which represents the number of meetings
     *                    that are holding at that time
     *  A little faster than above solution
     */
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        if (intervals.length == 1) return 1;
        
        Arrays.sort(intervals, (a, b) -> a.start - b.start); // Time complexity -> O(nlogn)
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.end - b.end); // minHeap
        int max = 0;
        
        for (int i = 0; i < intervals.length; i++) {
            while (!pq.isEmpty() && intervals[i].start >= pq.peek().end) pq.poll();
            pq.offer(intervals[i]);
            max = Math.max(max, pq.size());
        }
        
        return max;
    }
}


