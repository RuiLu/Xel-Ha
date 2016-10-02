public class Solution {
    /**
     *  Time complexity -> O(n!)
     *  Space complexity -> O(n!)
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows <= 0) return lists;
        
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            if (i == 1) {
                list.add(1);
                lists.add(list);
            } else if (i == 2) {
                list.add(1);
                list.add(1);
                lists.add(list);
            } else if (i > 2) {
                for (int j = 1; j <= i; j++) {
                    if (j == 1 || j == i) {
                        list.add(1);
                    } else {
                        int prevRow = lists.size() - 1;
                        list.add(lists.get(prevRow).get(j-2) + lists.get(prevRow).get(j-1));
                    }
                }
                lists.add(list);
            }
        }
        
        return lists;
    }
}
