package lab01.tdd;

import lab01.tdd.CircularList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private final List<Integer> list;
    private int position;

    public CircularListImpl() {
        this.list = new ArrayList<>();
        this.position = 0;
    }

    @Override
    public void add(final int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
       return this.isEmpty() ? Optional.empty() : Optional.of(this.getNext());
    }

    private Integer getNext() {
        return this.list.get(this.position++ % this.list.size());
    }

    @Override
    public Optional<Integer> previous() {
        return Optional.empty();
    }

    @Override
    public void reset() {

    }
}
