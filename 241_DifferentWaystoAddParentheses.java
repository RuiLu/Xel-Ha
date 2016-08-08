public class Solution {

    // Map is used to skip the duplicates, saving time   
    public List<Integer> diffWaysToCompute(String input) {
        return dfs(input, new HashMap<String, List<Integer>>());
    }
    
    private List<Integer> dfs(String input, HashMap<String, List<Integer>> map) {
        if (map.containsKey(input)) return map.get(input);
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            if (curr == '+' || curr == '-' || curr == '*') {
                String leftPart = input.substring(0, i);
                String rightPart = input.substring(i+1);
                List<Integer> leftRes = dfs(leftPart, map);
                List<Integer> rightRes = dfs(rightPart, map);
                for (Integer i1 : leftRes) {
                    for (Integer i2 : rightRes) {
                        int s = 0;
                        switch(curr) {
                            case '+':
                                s = i1 + i2;
                                break;
                            case '-':
                                s = i1 - i2;
                                break;
                            case '*':
                                s = i1 * i2;
                                break;
                        }
                        res.add(s);
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input));
        map.put(input, res);
        return res;
    }
    
    // public List<Integer> diffWaysToCompute(String input) {
    //     List<Integer> res = new ArrayList<>();
    //     for (int i = 0; i < input.length(); i++) {
    //         char curr = input.charAt(i);
    //         if (curr == '+' || curr == '-' || curr == '*') {
    //             String leftPart = input.substring(0, i);
    //             String rightPart = input.substring(i+1);
    //             List<Integer> leftRes = diffWaysToCompute(leftPart);
    //             List<Integer> rightRes = diffWaysToCompute(rightPart);
    //             for (Integer i1 : leftRes) {
    //                 for (Integer i2 : rightRes) {
    //                     int s = 0;
    //                     switch(curr) {
    //                         case '+': 
    //                             s = i1 + i2;
    //                             break;
    //                         case '-':
    //                             s = i1 - i2;
    //                             break;
    //                         case '*':
    //                             s = i1 * i2;
    //                     }
    //                     res.add(s);
    //                 }
    //             }
    //         }
    //     }
    //     if (res.size() == 0) {
    //         res.add(Integer.valueOf(input));
    //     }
    //     return res;
    // }
}
