package ds.list;

class Node {
    String value;
    Node next;
    Node prev;
}

public class LinkedList {
    Node head;
    Node tail;

    public LinkedList(){
        head = null;
        tail = null;
    }

    /**
     * Додавання нового елементу в кінець списку;
     * @param element що хочете додати до списку
     */
    void add(String element){
        // TODO: add(element)
    }

    /**
     * Додавання нового елементу за індексом;
     * @param element що хочете додати
     * @param index індекс нового елементу
     */
    void add(String element, int index){
        // TODO: add(element, index)
    }

    /**
     * Отримання першого елемента
     * @return перший елемент списку
     */
    String getFirst() {
        // TODO: getFirst()
        return null;
    }

    /**
     * Отримання останнього елемента
     * @return останній елемент списку
     */
    String getLast(){
        // TODO: getLast()
        return null;
    }
}
