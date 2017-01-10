public class Solution {
    /**
     *  Idea -> Bucket sort
     *  Time complexity -> O(n)
     */
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) return s;
        
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        List<Character>[] bucket = new List[s.length()+1];
        
        // Calculate every character's frequency
        for (char ch : s.toCharArray()) map.put(ch, map.getOrDefault(ch, 0)+1);
        for (char key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        
        for (int i = bucket.length-1; i >= 0; i--) {
            if (bucket[i] == null) continue;
            
            for (char ch : bucket[i]) {
                int freq = i;
                while (freq-- > 0) sb.append(ch);
            }
        }
        
        return sb.toString();
    } 
     
    /**
     *  Idea -> HashMap + MaxHeap
     *  Time complexity -> O(nlogn)
     */
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) return s;
        
        StringBuilder sb = new StringBuilder();
        // Frequency map
        HashMap<Character, Integer> frequency = new HashMap<>();
        // Type of this PriorityQueue is an array with length 2, 1st element is character, 2nd is frequency.
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
          public int compare(int[] node1, int[] node2) {
              return node2[1]-node1[1];
          } 
        });
        
        for (char ch : s.toCharArray()) frequency.put(ch, frequency.getOrDefault(ch, 0)+1);
        for (char key : frequency.keySet()) pq.offer(new int[]{key-'a', frequency.get(key)});
        
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            for (int i = 0; i < node[1]; i++) sb.append((char)(node[0]+'a'));
        }
        
        return sb.toString();
    }
}
