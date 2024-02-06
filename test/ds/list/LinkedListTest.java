package ds.list;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

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
    @Test
    void clear(){
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.clear();
        assertTrue(list.isEmpty());

        list = new LinkedList();
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void copyOf(){
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        LinkedList copyList = LinkedList.copyOf(list);
        assertEquals(list.toString(), copyList.toString());

        list = new LinkedList();
        list.add("A");
        LinkedList copyList2 = LinkedList.copyOf(list);
        assertEquals(list.toString(), copyList2.toString());

        list = new LinkedList();
        LinkedList copyList3 = LinkedList.copyOf(list);
        assertEquals(list.toString(), copyList3.toString());
    }

    @Test
    void reversed(){
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        LinkedList reversedList = list.reversed();
        assertEquals("[D, C, B, A]", reversedList.toString());
        list = new LinkedList();
        list.add("A");
        list.add("B");
        reversedList = list.reversed();
        assertEquals("[B, A]", reversedList.toString());
        // reverse an empty list
        list = new LinkedList();
        assertEquals("[]", list.reversed().toString());
    }

    Object getObject() {
        return new Object();
    }

    @Test
    void equalsExample(){
        // tests contains
        /*
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        assertTrue(list.equals("A"));
        assertFalse(list.equals("K"));
         */

        Object obj1 = "hello";
        Object obj2 = new TreeMap<>();

//        if (obj1 == obj2) {
//            System.out.println("obj1 == obj2");
//        } else {
//            System.out.println("obj1 ❌ obj2");
//        }

        // comparison for an equality
        // primitive data types are not objects
        byte b = 100;
        int numb = 100;
        char c = '&';
        // byte, short, int, long, char, double, float, boolean
        Object manager = getObject();
        int[] arr = new int[12];

        /*
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        map1.put("C", 3);

        TreeMap<String, Integer> map2 = new TreeMap<>();
        map2.put("A", 1);
        map2.put("B", 2);
        map2.put("C", 3);
//        if (map1 == map2){
//            System.out.println("Адреса однакові");
//        } else {
//            System.out.println("Адреса різні");
//        }

        if (map1.equals(map2)){
            System.out.println("Однакові");
        } else {
            System.out.println("Різні");
        }

         */


    }

    @Test
    void equals() {
        LinkedList list1 = new LinkedList();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");

        LinkedList list2 = new LinkedList();
        list2.add("A");
        list2.add("B");
        list2.add("C");
        list2.add("D");
        assertFalse(list1 == list2);
        assertTrue(list1.equals(list2));

        list1 = new LinkedList();
        list2 = new LinkedList();
        assertFalse(list1 == list2);
        assertTrue(list1.equals(list2));

        list1 = new LinkedList();
        list1.add("A");
        list2 = new LinkedList();
        list2.add("A");
        assertFalse(list1 == list2);
        assertTrue(list1.equals(list2));
    }

    @Test
    void isEqualTo(){
        LinkedList list1 = new LinkedList();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");

        LinkedList list2 = new LinkedList();
        list2.add("A");
        list2.add("B");
        list2.add("C");
        list2.add("D");
        assertTrue(list1.isEqualTo(list2));

        list2 = new LinkedList();
        list2.add("K");
        list2.add("B");
        list2.add("H");
        list2.add("B");
        assertFalse(list1.isEqualTo(list2));
    }
}