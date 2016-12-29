// 1. HashMap (slow)
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (!map.containsKey(sc)) {
                if (map.containsValue(tc)) return false;
                map.put(sc, tc);
        
            } else {
                if (map.get(sc) != tc) return false;
            }
        }
        return true;
    }
}

// 2. Char array (fast)
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] sca = s.toCharArray();
        char[] tca = t.toCharArray();
        
        char[] sm = new char[256];
        char[] tm = new char[256];
        
        for (int i = 0; i < s.length(); i++) {
            char sc = sca[i];
            char tc = tca[i];
            if (sm[sc] == 0 && tm[tc] == 0) {
                sm[sc] = tc;
                tm[tc] = sc;
            } else {
                if (sm[sc] != tc || tm[tc] != sc) return false;
            }
        }
        return true;
    }
}
