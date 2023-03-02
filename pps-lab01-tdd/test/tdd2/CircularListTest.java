package tdd2;

import lab01.tdd2.IterableCircularList;
import lab01.tdd2.IterableCircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CircularListTest {

    private IterableCircularList<Integer> list;

    @BeforeEach
    void beforeEach(){
        this.list = new IterableCircularListImpl();
    }

    @Test
    void testForwardIterator() {
        final var iterator = this.list.forwardIterator();
        this.list.add(3);
        assertEquals(3, iterator.next());

    }

    @Test
    void testForwardIteratorOnEmptyList() {
        final var iterator = this.list.forwardIterator();
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void testBackwardIterator() {
        final var iterator = this.list.backwardIterator();
        this.list.add(3);
        this.list.add(5);
        assertEquals(5, iterator.next());
    }

    @Test
    void testBackwardIteratorOnEmptyList() {
        final var iterator = this.list.backwardIterator();
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void testMultipleForwardIterations() {
        this.list.add(5);
        this.list.add(7);
        this.list.add(3);
        final var iterator = this.list.forwardIterator();
        iterator.next();
        iterator.next();
        assertEquals(3, iterator.next());
    }

    @Test
    void testMultipleBackwardsIterations() {
        this.list.add(5);
        this.list.add(7);
        final var iterator = this.list.backwardIterator();
        iterator.next();
        iterator.next();
        assertEquals(7, iterator.next());
    }

    @Test
    void testForwardAndBackwardsIterations() {
        this.list.add(5);
        this.list.add(7);
        final var forwardIterator = this.list.forwardIterator();
        final var backwardIterator = this.list.backwardIterator();
        assertEquals(5, forwardIterator.next());
        assertEquals(7, backwardIterator.next());
    }

}
