package java8test.ch9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

public interface CollectionCustom<E> extends Collection<E> {
    default boolean removeIf(Predicate<? super E> filter) {
        boolean removed = false;
        Iterator<E> each = iterator();
        while(each.hasNext()) {
            if(filter.test(each.next())) {
                each.remove();
                removed = true;
            }
        }
        return removed;
    }
}
