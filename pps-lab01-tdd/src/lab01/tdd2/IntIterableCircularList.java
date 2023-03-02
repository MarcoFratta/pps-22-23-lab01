package lab01.tdd2;

import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;

public class IntIterableCircularList implements IterableCircularList<Integer> {

    private final CircularList list;

    public IntIterableCircularList() {
        this.list = new CircularListImpl();
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return new CircularListIteratorImpl(this.list::next);
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return new CircularListIteratorImpl(this.list::previous);}

    @Override
    public void add(final Integer i) {
        this.list.add(i);
    }


    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    private class CircularListIteratorImpl extends CircularListIterator<Integer> {

        private final Supplier<Optional<Integer>> stepFunction;

        protected CircularListIteratorImpl(final Supplier<Optional<Integer>> stepFunction) {
            super(IntIterableCircularList.this.list);
            this.stepFunction = stepFunction;
        }

        @Override
        public Integer next() {
            return this.stepFunction.get().orElseThrow(NoSuchElementException::new);
        }
    }

}
