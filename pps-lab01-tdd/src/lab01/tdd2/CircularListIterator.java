package lab01.tdd2;

import lab01.tdd.CircularList;

import java.util.Iterator;

public abstract class CircularListIterator<T> implements Iterator<T> {

    private final CircularList list;

    protected CircularListIterator(final CircularList list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return !this.list.isEmpty();
    }

    @Override
    abstract public T next();
}
