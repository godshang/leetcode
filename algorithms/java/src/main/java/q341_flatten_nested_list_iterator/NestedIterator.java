package q341_flatten_nested_list_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    
    private Iterator<Integer> iter;

    public NestedIterator(List<NestedInteger> nestedList) {
        List<Integer> res = new ArrayList<>();
        for (NestedInteger i : nestedList) {
            traverse(i, res);
        }
        iter = res.iterator();
    }
    
    private void traverse(NestedInteger nestedInteger, List<Integer> res) {
        if (nestedInteger.isInteger()) {
            res.add(nestedInteger.getInteger());
        } else {
            for (NestedInteger i : nestedInteger.getList()) {
                traverse(i, res);
            }
        }
    }

    @Override
    public Integer next() {
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }
}
