import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        this.populateListRandomly(listSize);
        assertEquals(listSize, this.list.size());
    }

    @Test
    void testNext(){
        this.populateListOrdered(3);
        final var v1 = this.list.next();
        final var v2 = this.list.next();
        assertEquals(0,this.checkExistence(v1));
        assertEquals(1, this.checkExistence(v2));
    }

    @Test
    void testNextOfEmptyList() {
        assertEquals(Optional.empty(), this.list.next());
    }

    @Test
    void testPrevious(){
        this.populateListOrdered(2);
        final var v1 = this.list.previous();
        final var v2 = this.list.previous();
        assertEquals(1,this.checkExistence(v1));
        assertEquals(0,this.checkExistence(v2));
    }
    @Test
    void testReset() {
       this.populateListRandomly(5);
       final var first = this.list.next();
       this.list.next();
       this.list.next();
       this.list.reset();
       assertEquals(first, this.list.next());
    }

    @Test
    void testNextAndPrev() {
        this.populateListOrdered(2);
        this.list.next();
        this.list.next();
        this.list.next();
        assertEquals(1,this.checkExistence(this.list.previous()));
    }

    @Test
    void testMultiplePrevious(){
        final int attempts = 10;
        this.populateListOrdered(attempts);

        for(int i = 0; i < attempts - 1 ; i++){
            this.list.previous();
        }

        final var value = this.list.previous();
        assertEquals(0, this.checkExistence(value));
    }

    @Test
    void testMultipleNext(){
        final int attempts = 10;
        this.populateListOrdered(attempts);

        for(int i = 0; i < attempts; i++){
            this.list.next();
        }

        final var value = this.list.next();
        assertEquals(0, this.checkExistence(value));
    }



    private void populateListRandomly(final int size){
        for(int i = 0; i < size; i++){
            this.list.add((int) (Math.random() * 100));
        }
    }

    private void populateListOrdered(final int size){
        for(int i = 0; i < size; i++){
            this.list.add(i);
        }
    }

    private <T> T checkExistence(final Optional<T> x){
        return x.orElseThrow(RuntimeException::new);
    }



}
