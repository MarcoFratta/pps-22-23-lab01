package lab01.tdd2;

import lab01.tdd.BaseList;

import java.util.Iterator;

public interface IterableCircularList<T> extends BaseList<T> {
    Iterator<T> forwardIterator();
    Iterator<T> backwardIterator();
}
