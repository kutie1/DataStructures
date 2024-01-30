package ds.list;

import java.util.Objects;

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
     * Отримання першого елемента
     * @return перший елемент списку
     */
    String getFirst() {
        if (head != null) {
            return head.value;
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * Отримання останнього елемента
     * @return останній елемент списку
     */
    String getLast(){
        if (tail != null) {
            return tail.value;
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * Перевірка чи міститься елемент у списку
     * @param element елемент який шукаємо
     * @return true or false
     */
    boolean contains(String element){
        Node current = head;
        while (current != null){
            if (Objects.equals(current.value, element)){
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

    /**
     * @return кількість елементів у списку (найменше – 0)
     */
    int size() {
        // TODO: size()
        Node current = head;
        int size = 0;
        while (current != null){
            size ++;
            current = current.next;
        }
        return size;
    }

    /**
     * Шукає індекс елемента
     * @param element елемент індекс якого шукаємо
     * @return індекс елементу, якщо елемент не знайдений, повертає -1
     */
    int indexOf(String element) {
        // TODO: indexOf(element)
        Node current = head;
        int index = 0;
        while (current != null){
            if (Objects.equals(current.value, element)){
                return index;
            }
            index ++;
            current = current.next;
        }
        return -1;
    }


    /**
     * Знаходить останній індекс елементу (останній раз коли елемент зустрічається у списку)
     * @param element елемент
     * @return останній індекс елементу, якщо елемент не знайдений, повертає -1
     */
    int lastIndexOf(String element) {
        // TODO: lastIndexOf(element)
//        Node head1 = head;
//        int size = 0;
//        while (head1 != null){
//            size ++;
//            head1 = head1.next;
//        }
        Node current = tail;
        int index = size();
        while (current != null){
            if (Objects.equals(current.value, element)){
                return index - 1;
            }
            index --;
            current = current.prev;
        }
        return -1;
    }

    /**
     * Видаляє елемент зі списку за індексом. Створюється помилка, якщо індекс виходить за межі
     * @param index
     * @return значення, яке було видалено
     */
    String remove(int index) {
        // TODO: remove(index)
        throw new IndexOutOfBoundsException();
    }


    /**
     * Видаляє перший елемент списку
     * @return видаленний елемент
     */
    String removeFirst(){
        // TODO: removeFirst()
        if (head == null){
            return null;
        }
        String headValue = head.value;
        head = head.next;
        return headValue;
    }

    /**
     * Видаляє останній елемент списку
     * @return видаленний елемент
     */
    String removeLast(){
        // TODO: removeLast()
        if (head == null) {
            return null;
        } else if (head == tail) {
            String removedValue = head.value;
            head = null;
            tail = null;
            return removedValue;
        } else {
            Node current = tail.prev;
            String removedValue = tail.value;
            tail = current;
            tail.next = null;
            return removedValue;
        }
    }

    /**
     * Робить заміну елементу, cтворюється помилка, якщо індекс виходить за межі
     * @param index куди замінити елемент
     * @param newValue нове значення
     * @return попередній елемент
     */
    String set(int index, String newValue) {
        // TODO: set(index, newValue)
        return null;
    }

    /**
     * Додавання нового елементу за індексом;
     * @param element що хочете додати
     * @param index індекс нового елементу
     */
    void add(String element, int index){
        // TODO: add(element, index)
        Node current = new Node();
        current.value = element;
        if (index == 0) {
            if (head != null) {
                addFirst(element);
            }
            head = current;
        } else if (index == size()){
            addLast(element);
        } else {
            Node node = head;
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            current.next = node.next;
            current.prev = node;
            node.next.prev = current;
            node.next = current;
        }

    }

    /**
     * Додає новий елемент у початок списку
     * @param element елемент який ми хочемо додати
     */
    void addFirst(String element){
        // TODO: addFirst()
        Node current = new Node();
        current.value = element;
        if (head == null) {
            head = current;
            tail = current;
        } else {
            current.next = head;
            head.prev = current;
            head = current;
        }
    }

    /**
     * Додає новий елемент у кінець списку
     * @param element елемент який ми хочемо додати
     */
    void addLast(String element){
        // TODO: addLast()
        Node current = new Node();
        current.value = element;
        if (head == null) {
            head = current;
            tail = current;
        } else {
            current.prev = tail;
            tail.next = current;
            tail = current;
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        sb.append(head.value);
        Node current = head.next;
        while (current != null) {
            sb.append(", ");
            sb.append(current.value);
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
