package tdd3;

import lab01.tdd3.FilteredCircularList;
import lab01.tdd3.IntFilteredCircularList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static tdd.Utils.checkExistence;
import static tdd.Utils.populateListOrdered;

public class CircularListTest {

    private FilteredCircularList<Integer> list;

    @BeforeEach
    void beforeEach(){
        this.list = new IntFilteredCircularList();
    }

    @Test
    void testFilteredCircularList(){
        this.list.add(1);
        this.list.add(5);
        assertEquals(5, checkExistence(this.list.filteredNext(x -> x > 3)));
    }

    @Test
    void testSizedCircularList(){
        this.list.add(1);
        this.list.add(5);
        assertEquals(2, this.list.size());
    }

    @Test
    void testInitialEmpty(){
        assertTrue(this.list.isEmpty());
    }

    @Test
    void testNoElementMatches(){
        populateListOrdered(this.list, 50);
        assertEquals(Optional.empty(),
                this.list.filteredNext(x -> x > 60));
    }

    @Test
    void testMultipleNext() {
        populateListOrdered(this.list, 30);
        assertEquals(10,
                checkExistence(this.list.filteredNext(x -> x >= 10)));
        assertEquals(10, checkExistence(this.list.filteredNext(x -> x == 10)));
    }
}
