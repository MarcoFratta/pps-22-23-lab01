package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class CircularListImpl implements CircularList {

    private static final int INITIAL_POS = -1;
    private final List<Integer> list;
    private int position;

    public CircularListImpl() {
        this.list = new ArrayList<>();
        this.position = INITIAL_POS;
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
    public void reset() {
        this.position = INITIAL_POS;
    }

    @Override
    public Optional<Integer> next() {
       return this.wrapWithOptional(() -> this.getItemAtNewPosition(this::nextPosition));
    }

    @Override
    public Optional<Integer> previous() {
        return this.wrapWithOptional(() -> this.getItemAtNewPosition(this::previousPosition));
    }

    
    private Optional<Integer> wrapWithOptional(final Supplier<Integer> extractor) {
        return this.isEmpty() ? Optional.empty() : Optional.of(extractor.get());
    }
    
    private int getItemAtNewPosition(final Supplier<Integer> newPositionSupplier) {
        this.position = newPositionSupplier.get();
        return this.list.get(this.position);
    }

    private Integer nextPosition() {
        return ++this.position % this.list.size();
    }

    private Integer previousPosition() {
        return --this.position < 0 ? this.size() - 1 : this.position;
    }
}
