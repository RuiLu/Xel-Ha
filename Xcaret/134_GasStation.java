public class Solution {
    /**
     *  Reference -> https://discuss.leetcode.com/topic/5088/my-ac-is-o-1-space-o-n-running-time-solution-does-anybody-have-posted-this-solution
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length - 1;
        int end = 0;
        int sum = gas[start] - cost[start];
        
        while (start > end) {
            if (sum >= 0) {
                sum += gas[end] - cost[end];
                end++;
            } else {
                start--;
                sum += gas[start] - cost[start];
            }
        }
        
        return sum >= 0 ? start : -1;
    } 
     
    /**
     *  Idea -> check start point one by one 
     *  Time complexity -> O(n^2)
     *  Space complexity -> O(1)
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        
        // first, if total sum of gas is less than the total sum of cost, return -1
        int diff = 0;
        for (int i = 0; i < len; i++) {
            diff += gas[i];
            diff -= cost[i];
        }
        if (diff < 0) return -1;
        
        // second, check availability one by one
        for (int i = 0; i < len; i++) {
            if (gas[i] < cost[i]) {
                continue;
            } else {
                boolean failed = false;
                int start = i;
                int remain = gas[i] - cost[i];
                i = (start + 1) % len;
                while (i != start) {
                    if (remain + gas[i] < cost[i]) {
                        failed = true;
                        break;
                    } else {
                        remain = remain + gas[i] - cost[i];
                        i = (i + 1) % len;
                    }
                }
                if (!failed) return start;
            }
        }
        
        return -1;
    }
}
