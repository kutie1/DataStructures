package ds.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LinkedListTest {

    @Test
    void add() {
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        assertEquals("[A, B, C, D]", list.toString());

        list = new LinkedList();
        assertEquals("[]", list.toString());

        list = new LinkedList();
        list.add("A");
        assertEquals("[A]", list.toString());
    }

    @Test
    void getFirst() {
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        assertEquals("A", list.getFirst());

        list = new LinkedList();
        assertThrows(IndexOutOfBoundsException.class, list::getFirst);
    }

    @Test
    void getLast() {
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        assertEquals("D", list.getLast());

        list = new LinkedList();
        assertThrows(IndexOutOfBoundsException.class, list::getLast);
    }

    @Test
    void contains() {
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        assertTrue(list.contains("B"));
        assertFalse(list.contains("K"));
    }

    @Test
    void isEmpty() {
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        assertFalse(list.isEmpty());

        list = new LinkedList();
        assertTrue(list.isEmpty());
    }

    @Test
    void size() {
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        assertEquals(4, list.size());

        list = new LinkedList();
        list.add("A");
        assertEquals(1, list.size());

        list = new LinkedList();
        assertEquals(0, list.size());

        // TODO: перевіряти size, коли у списку змінюється кількість елементів:
        //    add(element), add(index, element), remove(index), removeLast()
    }

    @Test
    void indexOf() {
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        assertEquals(2, list.indexOf("C"));
        assertEquals(-1, list.indexOf("K"));
        list = new LinkedList();
        assertEquals(-1, list.indexOf("C"));
    }

    @Test
    void lastIndexOf() {
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("A");
        list.add("D");
        assertEquals(2, list.lastIndexOf("A"));
        assertEquals(-1, list.lastIndexOf("K"));
    }

    @Test
    void remove() {
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        assertEquals("C", list.remove(2));
        assertEquals("[A, B, D]", list.toString());

        LinkedList finalList = list;
        assertThrows(IndexOutOfBoundsException.class, () -> finalList.remove(3));
        assertThrows(IndexOutOfBoundsException.class, () -> finalList.remove(-5));
        assertThrows(IndexOutOfBoundsException.class, () -> finalList.remove(2000000));

        list = new LinkedList();
        list.add("A");
        assertEquals("A", list.remove(0));
        assertTrue(list.isEmpty());
    }

    @Test
    void removeFirst() {
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        assertEquals("A", list.removeFirst());
        assertEquals("[B, C, D]", list.toString());

        list = new LinkedList();
        list.add("A");
        assertEquals("A", list.removeFirst());
        assertTrue(list.isEmpty());
    }

    @Test
    void removeLast() {
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        assertEquals("D", list.removeLast());
        assertEquals("[A, B, C]", list.toString());

        list = new LinkedList();
        list.add("A");
        assertEquals("A", list.removeLast());
        assertTrue(list.isEmpty());
    }

    @Test
    void set() {
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        assertEquals("B", list.set(1, "K"));
        assertEquals("[A, K, C, D]", list.toString());
    }

    @Test
    void testAddByIndex() {
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("K", 2);
        assertEquals("[A, B, K, C, D]", list.toString());

        list = new LinkedList();
        list.add("A", 0);
        assertEquals("A", list.getFirst());

        list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("P", 3);
        assertEquals("[A, B, C, P, D]", list.toString());

        list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("P", 0);
        assertEquals("[P, A, B, C, D]", list.toString());

        list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("M", 4);
        assertEquals("[A, B, C, D, M]", list.toString());
    }

    @Test
    void addFirst() {
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.addFirst("W");
        assertEquals("[W, A, B, C, D]", list.toString());

        list = new LinkedList();
        list.addFirst("A");
        assertEquals("A", list.getFirst());
        assertEquals("[A]", list.toString());
    }

    @Test
    void addLast() {
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.addLast("W");
        assertEquals("[A, B, C, D, W]", list.toString());

        list = new LinkedList();
        list.addLast("A");
        assertEquals("[A]", list.toString());
    }
}