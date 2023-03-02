package lab01.tdd2;

import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;

public class IterableCircularListImpl implements IterableCircularList<Integer> {

    private final CircularList list;

    public IterableCircularListImpl() {
        this.list = new CircularListImpl();
    }


    @Override
    public Iterator<Integer> forwardIterator() {
        return new CircularListIteratorImpl(this.list::next);
    }

    @Override
    public Iterator<Integer> backwardIterator() { return new CircularListIteratorImpl(this.list::previous);}

    @Override
    public void add(final Integer i) {
        this.list.add(i);
    }

    private class CircularListIteratorImpl extends CircularListIterator<Integer> {

        private final Supplier<Optional<Integer>> stepFunction;

        protected CircularListIteratorImpl(final Supplier<Optional<Integer>> stepFunction) {
            super(IterableCircularListImpl.this.list);
            this.stepFunction = stepFunction;
        }

        @Override
        public Integer next() {
            return this.stepFunction.get().orElseThrow(NoSuchElementException::new);
        }
    }

}
