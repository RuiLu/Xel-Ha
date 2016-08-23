/**
 *  Time complexity -> O(TlogT), where T is the number of tickets
 */
public class Solution {
    /**
     *  1. recursion
     */
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> itinerary = new LinkedList<>();
    
    public List<String> findItinerary(String[][] tickets) {
        if (tickets == null || tickets.length == 0 || tickets[0].length == 0) return itinerary;
        
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            PriorityQueue<String> pq = new PriorityQueue<>();
            if (map.containsKey(from)) pq = map.get(from);
            pq.offer(ticket[1]);
            map.put(from, pq);
        }
        
        dfs("JFK");
        
        return itinerary;
    }
    
    private void dfs(String next) {
        while (map.containsKey(next) && !map.get(next).isEmpty()) dfs(map.get(next).poll());
        itinerary.addFirst(next);
    }
    
    /**
     *  2. iteration, with the helper of Stack
     */
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> itinerary = new LinkedList<>();
        if (tickets == null || tickets.length == 0 || tickets[0].length == 0) return itinerary;
        
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            
            PriorityQueue<String> pq = new PriorityQueue<>();
            if (map.containsKey(from)) pq = map.get(from);
            pq.offer(to);
            map.put(from, pq);
        }
        
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        
        while (!stack.empty()) {
            while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()) {
                stack.push(map.get(stack.peek()).poll());
            }
            itinerary.addFirst(stack.pop());
        }
        
        return itinerary;
    }
}
