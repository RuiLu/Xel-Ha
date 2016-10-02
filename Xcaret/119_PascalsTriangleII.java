public class Solution {
    public List<Integer> getRow(int rowIndex) {
        /**
         *  Idea -> maintaining the original list
         *          0 -> 1
         *          1 -> 1 1
         *          2 -> 1 1 1 -> 1 2 1
         *          3 -> 1 1 2 1 -> 1 3 3 1
         *          so on and so forth
         *  Time complexity -> O(k)
         *  Space complexity -> O(1)
         */
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0) return list;
        
        for (int i = 0; i <= rowIndex; i++) {
            list.add(0, 1);
            for (int j = 1; j < i; j++) {
                list.set(j, list.get(j) + list.get(j+1));
            }
        }
        
        return list;
    }
}
