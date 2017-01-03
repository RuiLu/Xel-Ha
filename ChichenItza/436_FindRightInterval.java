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
     *  Idea -> Binary search.
     *          1. Initialize a new array storing each interval's start point.
     *          2. Create a HashMap to keep track the original start point and index pair.
     *          3. Sort the start point array
     *          4. Do binary search on start point array with each interval's end point as target.
     * 
     *  Time complexity -> O(nlogn)
     */
    private int binarySearch(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo+hi) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    } 
     
    public int[] findRightInterval(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0];
        
        int len = intervals.length;
        int[] res = new int[len];
        int[] startPoints = new int[len];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Create a start point array
        // Meanwhile, create the original start point and index pair map.
        for (int i = 0; i < len; i++) {
            startPoints[i] = intervals[i].start;
            map.put(intervals[i].start, i);
        }
        // sort the start point array used for binary search
        Arrays.sort(startPoints);
        
        for (int i = 0; i < len; i++) {
            int end = intervals[i].end;
            int index = binarySearch(startPoints, end);
            if (index == len) res[i] = -1;
            else res[i] = map.get(startPoints[index]);
        }
        
        return res;
    }
    
    /**
     *  Idea -> Naive way, TLE...
     *  Time complexity -> O(n^2)
     */
    // public int[] findRightInterval(Interval[] intervals) {
    //     if (intervals == null || intervals.length == 0) return new int[0];
        
    //     int[] res = new int[intervals.length];
        
    //     for (int i = 0; i < intervals.length; i++) {
    //         int otherStart = Integer.MAX_VALUE;
    //         int index = -1;
    //         int end = intervals[i].end;
    //         for (int j = 0; j < intervals.length; j++) {
    //             if (i == j) continue;
    //             if (intervals[j].start >= end) {
    //                 if (intervals[j].start < otherStart) {
    //                     otherStart = intervals[j].start;
    //                     index = j;
    //                 }
    //             }
    //         }
    //         res[i] = index;
    //     }
        
    //     return res;
    // }
}
