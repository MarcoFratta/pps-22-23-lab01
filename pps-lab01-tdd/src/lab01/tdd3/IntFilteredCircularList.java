package lab01.tdd3;

import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IntFilteredCircularList implements FilteredCircularList<Integer> {


    private final CircularList list;

    public IntFilteredCircularList(){
        this.list = new CircularListImpl();
    }

    @Override
    public Optional<Integer> filteredNext(final Predicate<Integer> predicate) {
        return this.list.isEmpty() ? Optional.empty() : this.getNext(predicate);
    }

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

    private Optional<Integer> getNext(final Predicate<Integer> predicate){
        return Stream.iterate(this.list.next(), (x) -> this.list.next())
                .limit(this.list.size())
                .map(Optional::get).filter(predicate).findFirst();
    }
}
