import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    private LinkedList<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new LinkedList<>();
    }

    @Test
    public void testAdd() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    @Test
    public void testRemove() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.remove(2));
        assertFalse(list.remove(4));
        assertEquals(2, list.size());
    }

    @Test
    public void testGet() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    @Test
    public void testSizeAndIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        list.remove(1);
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }
}
