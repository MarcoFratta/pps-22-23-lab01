package tdd2;

import lab01.tdd2.CircularList;
import org.junit.jupiter.api.BeforeEach;

public class CircularListTest {

    private CircularList list;

    @BeforeEach
    void beforeEach(){
        this.list = new CircularListImpl();
    }

    
}
