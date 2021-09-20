package q341_flatten_nested_list_iterator;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        NestedInteger i1 = new NestedIntegerImpl(1);
        NestedInteger i2 = new NestedIntegerImpl(1);
        NestedInteger i3 = new NestedIntegerImpl(2);
        NestedInteger i4 = new NestedIntegerImpl(1);
        NestedInteger i5 = new NestedIntegerImpl(1);
        NestedInteger i12 = new NestedIntegerImpl(Arrays.asList(i1, i2));
        NestedInteger i45 = new NestedIntegerImpl(Arrays.asList(i4, i5));
        NestedInteger nestedInteger = new NestedIntegerImpl(Arrays.asList(i12, i3, i45));
        
        NestedIterator2 iterator = new NestedIterator2(Arrays.asList(nestedInteger));
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}


