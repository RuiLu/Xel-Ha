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
     *  Idea -> Using a MinHeap
     *  Time complexity -> O(nlogn)
     */
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        
        int minRooms = 0;
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.end - b.end);
        
        for (Interval i : intervals) {
            while (!pq.isEmpty() && pq.peek().end <= i.start) pq.poll();
            pq.offer(i);
            minRooms = Math.max(minRooms, pq.size());
        }
        
        return minRooms;
    } 
     
    /**
     *  Idea -> start: -1, end: 1, take Interval apart into start time and end time
     *          sort these times, if there are same time, sort by -1 and 1
     *  Time complexity -> O(nlog2n)
     */
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        
        List<int[]> list = new ArrayList<>();
        int minRooms = 0;
        int res = Integer.MIN_VALUE;
        
        for (Interval i : intervals) {
            list.add(new int[]{i.start, -1});
            list.add(new int[]{i.end, 1});
        }
        
        Collections.sort(list, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        
        for (int[] time : list) {
            if (time[1] == -1) minRooms++;
            else if (time[1] == 1) minRooms--;
            
            res = Math.max(res, minRooms);
        }
        
        return res;
    }
}
