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
        Node newNode = new Node();
        newNode.value = element;

        if (head == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
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
        if (head != null) {
            return head.value;
        }
    }

    /**
     * Отримання останнього елемента
     * @return останній елемент списку
     */
    String getLast(){
        // TODO: getLast()
        if (tail != null) {
            return tail.value;
        }
        return null;
    }

    /**
     * Перевірка чи міститься елемент у списку
     * @param element елемент який шукаємо
     * @return true or false
     */
    boolean contains(String element){
        Node current = head;
        while (current != null){
            if (current.value == element){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Перевірка чи не пустий список
     * @return true or false
     */
    boolean isEmpty(){
        if (head == null){
            return true;
        }
        return false;
    }
}
