package lab01.tdd3;

import lab01.tdd.BaseList;

import java.util.Optional;
import java.util.function.Predicate;

public interface FilteredCircularList<T> extends BaseList<T> {

    Optional<T> filteredNext(Predicate<T> predicate);
}
