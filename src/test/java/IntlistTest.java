import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.Intlist;
import pro.sky.java.course2.IntlistImpl;
import pro.sky.java.course2.exception.ListFillException;
import pro.sky.java.course2.exception.NotFoundElement;

import static org.junit.jupiter.api.Assertions.*;

public class IntlistTest {
    Integer INT1 = 1;
    Integer INT2 = 2;
    Intlist out = new IntlistImpl();
    Intlist out3 = new IntlistImpl();
    Intlist out1 = new IntlistImpl(4);
    Intlist out2 = new IntlistImpl(5);


    @Test
    public void addTest() {
        out.add(INT1);
        assertTrue(out.contains(INT1));
        assertFalse(out.contains(INT2));
        assertThrows(NullPointerException.class, () -> out.add(null));
        assertEquals(out.size(), 1);
    }

    @Test
    public void addTestWhenFillList() {
        out1.add(INT1);
        out1.add(INT1);
        out1.add(INT1);
        out1.add(INT1);
        assertThrows(ListFillException.class, () -> out1.add(INT2));
        assertThrows(ListFillException.class, () -> out1.add(1, INT2));
    }

    @Test
    public void addByIndexTest() {
        out.add(0, INT1);
        assertTrue(out.contains(INT1));
        assertFalse(out.contains(INT2));
        assertThrows(NullPointerException.class, () -> out.add(0, null));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> out.add(-1, INT2));
    }

    @Test
    public void setTest() {
        out.add(0, INT1);
        out.set(0, INT2);
        assertTrue(out.contains(INT2));
        assertFalse(out.contains(INT1));
        assertThrows(NullPointerException.class, () -> out.set(0, null));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> out.set(-1, INT1));

    }

    @Test
    public void removeTest() {
        out.add(INT1);
        out.remove(INT1);
        assertFalse(out.contains(INT1));
        assertThrows(NotFoundElement.class, () -> out.remove(INT2));

    }

    @Test
    public void removeByIndexTest() {
        out.add(0, INT1);
        out.remove(0);
        assertFalse(out.contains(INT1));
        assertThrows(NullPointerException.class, () -> out.remove(2));

    }

    @Test
    public void containsTest() {
        out.add(INT1);

        assertTrue(out.contains(INT1));
        assertFalse(out.contains(INT2));

    }

    @Test
    public void indexOfTest() {
        out.add(INT1);

        assertTrue(out.indexOf(INT1) == 0);
        assertTrue(out.indexOf(INT2) == -1);

    }

    @Test
    public void indexLastOfTest() {
        out.add(INT1);

        assertTrue(out.lastIndexOf(INT1) == 0);
        assertTrue(out.lastIndexOf(INT2) == -1);

    }

    @Test
    public void getTest() {
        out.add(INT1);
        assertTrue(out.get(0).equals(INT1));
        assertFalse(out.get(0).equals(INT2));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> out.get(-5));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> out.get(1));

    }

    @Test
    public void equalsTest() {
        out.add(INT1);
        out.add(INT2);
        out3.add(INT1);
        out3.add(INT2);
        out2.add(INT1);
        out2.add(INT1);
        assertTrue(out.equals(out3));
        assertFalse(out.equals(out2));
    }

    @Test
    public void sizeTest() {
        out.add(INT1);
        out.add(INT2);
        assertTrue(out.size() == 2);

    }

    @Test
    public void isEmptyTest() {
        assertTrue(out.isEmpty());
        out1.add(INT1);
        assertFalse(out1.isEmpty());
    }

    @Test
    public void clearTest() {
        out.add(INT1);
        out.add(INT2);
        out.clear();
        assertTrue(out.isEmpty());

    }

    @Test
    public void toArrayTest() {
        out.add(INT1);
        out.add(INT2);
        assertTrue(out.equals(out.toArray()));


    }
}
