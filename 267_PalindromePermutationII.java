c class Solution {
    public List<String> generatePalindromes(String s) {
    
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        
        int[] map = new int[256];
        int odd = 0;
        String mid = "";
      
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map[ch]++;
            odd += map[ch] % 2 == 0 ? -1 : 1;
        }
        
        if (odd > 1) return res;
        
        for (int i = 0; i < map.length; i++) {
            if (map[i] % 2 != 0) {
                mid += (char)i;
                map[i]--; // take the unique mid out, so minus one
                break;
            }
        }
        
        getAllPermutations(res, mid, map, s.length());
        
        return res;
    }
    
    private void getAllPermutations(List<String> res, String mid, int[] map, int len) {
        if (mid.length() == len) {
            res.add(mid);
        } else {
            for (int i = 0; i < map.length; i++) {
                if (map[i] <= 0) continue;
                map[i] -= 2;
                mid = (char)i + mid + (char)i;
                getAllPermutations(res, mid, map, len);
                map[i] += 2;
                mid = mid.substring(1, mid.length() - 1);
            }
        }
    }
}
