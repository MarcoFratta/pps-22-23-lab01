package tdd;

import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static tdd.Utils.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList list;

    @BeforeEach
    void beforeEach(){
        this.list = new CircularListImpl();
    }

    @Test
    void testInitialEmpty(){
        assertTrue(this.list.isEmpty());
    }

    @Test
    void testAdd(){
        this.list.add(3);
        final var size = this.list.size();
        assertEquals(1, size);
    }

    @Test
    void testSize(){
        final int listSize = 30;
        populateListRandomly(this.list,listSize);
        assertEquals(listSize, this.list.size());
    }

    @Test
    void testNext(){
        populateListOrdered(this.list,3);
        final var v1 = this.list.next();
        final var v2 = this.list.next();
        assertEquals(0, checkExistence(v1));
        assertEquals(1, checkExistence(v2));
    }

    @Test
    void testNextOfEmptyList() {
        assertEquals(Optional.empty(), this.list.next());
    }

    @Test
    void testPrevious(){
        populateListOrdered(this.list,2);
        final var v1 = this.list.previous();
        final var v2 = this.list.previous();
        assertEquals(1, checkExistence(v1));
        assertEquals(0, checkExistence(v2));
    }
    @Test
    void testReset() {
       populateListRandomly(this.list,5);
       final var first = this.list.next();
       this.list.next();
       this.list.next();
       this.list.reset();
       assertEquals(first, this.list.next());
    }

    @Test
    void testNextAndPrev() {
        populateListOrdered(this.list,2);
        this.list.next();
        this.list.next();
        this.list.next();
        assertEquals(1, checkExistence(this.list.previous()));
    }

    @Test
    void testMultiplePrevious(){
        final int attempts = 10;
        populateListOrdered(this.list,attempts);

        for(int i = 0; i < attempts - 1 ; i++){
            this.list.previous();
        }

        final var value = this.list.previous();
        assertEquals(0, checkExistence(value));
    }

    @Test
    void testMultipleNext(){
        final int attempts = 10;
        populateListOrdered(this.list,attempts);

        for(int i = 0; i < attempts; i++){
            this.list.next();
        }

        final var value = this.list.next();
        assertEquals(0, checkExistence(value));
    }
}
