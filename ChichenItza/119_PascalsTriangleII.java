public class Solution {
    /**
     *  Idea -> update result ArrayList
     *  Time complexity -> O(rowIndex)
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            if (i == 1) {
                res.add(1);
                continue;
            }
            for (int j = 0; j < res.size() - 1; j++) {
                res.set(j, res.get(j) + res.get(j+1));
            }
            res.add(0, 1);
        }
        
        return res;
    }
}
