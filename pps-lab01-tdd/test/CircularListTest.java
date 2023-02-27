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
        this.list.add(3);
        this.list.add(5);
        this.list.add(3);
        assertEquals(3, this.list.size());
    }

    @Test
    void testNext(){
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);
        assertEquals(1,this.list.next().get());
        assertEquals(2, this.list.next().get());
    }

    @Test
    void testNextOfEmptyList() {
        assertEquals(Optional.empty(), this.list.next());
    }

}
