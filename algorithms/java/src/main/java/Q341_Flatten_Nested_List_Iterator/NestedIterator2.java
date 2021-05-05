package q341_flatten_nested_list_iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestedIterator2 implements Iterator<Integer> {
    
    private LinkedList<NestedInteger> list;

    public NestedIterator2(List<NestedInteger> nestedList) {
        this.list = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        return list.removeFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!list.isEmpty() && !list.get(0).isInteger()) {
            List<NestedInteger> first = list.remove(0).getList();
            for (int i = first.size() - 1; i >= 0; i--) {
                list.addFirst(first.get(i));
            }
        }
        return !list.isEmpty();
    }
}
