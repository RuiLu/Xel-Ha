public class Vector2D implements Iterator<Integer> {
    /**
     *  Idea -> Using a ListIterator
     */
    private List<Integer> list = null;
    private ListIterator<Integer> li = null;

    public Vector2D(List<List<Integer>> vec2d) {
        list = new ArrayList<>();
        
        for (int i = 0; i < vec2d.size(); i++) {
            for (int j = 0; j < vec2d.get(i).size(); j++) {
                list.add(vec2d.get(i).get(j));
            }    
        }
        
        li = list.listIterator();
    }

    @Override
    public Integer next() {
        return li.next();
    }

    @Override
    public boolean hasNext() {
        return li.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
