package lab01.tdd2;

import java.util.Iterator;

public interface IterableCircularList<T> {

    Iterator<T> forwardIterator();
    Iterator<T> backwardIterator();
    void add(T i);
}
