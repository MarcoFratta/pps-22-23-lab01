package tdd2;

import lab01.tdd2.IterableCircularList;
import lab01.tdd2.IntIterableCircularList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static tdd.Utils.populateListOrdered;

public class CircularListTest {

    private IterableCircularList<Integer> list;

    @BeforeEach
    void beforeEach(){
        this.list = new IntIterableCircularList();
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
        populateListOrdered(this.list, 3);
        final var iterator = this.list.forwardIterator();
        iterator.next();
        iterator.next();
        assertEquals(2, iterator.next());
    }

    @Test
    void testMultipleBackwardsIterations() {
        populateListOrdered(this.list, 3);
        final var iterator = this.list.backwardIterator();
        iterator.next();
        iterator.next();
        assertEquals(0, iterator.next());
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

    @Test
    void testSizes(){
        this.list.add(4);
        assertEquals(1, this.list.size());
    }

    @Test
    void testInitialEmpty(){
        assertTrue(this.list.isEmpty());
    }

}
