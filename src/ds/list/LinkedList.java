package ds.list;

import java.util.Arrays;
import java.util.HashMap;
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

    static LinkedList ofInts(int[] array) {
        LinkedList list = new LinkedList();
        for (int n : array){
            list.add(String.valueOf(n));
        }
        return list;
    }

    /**
     * Додавання нового елементу в кінець списку;
     * @param element що хочете додати до списку
     */
    void add(String element){
        Node newNode = new Node();
        newNode.value = element;

        if (head == null){
            head = tail = newNode;
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
        if (!isEmpty()) {
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
        Node current = head;
        int size = 0;
        while (current != null){
            size++;
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
        Node current = head;
        int index = 0;
        while (current != null){
            if (Objects.equals(current.value, element)){
                return index;
            }
            index++;
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
        Node current = tail;
        int index = size();
        while (current != null){
            if (Objects.equals(current.value, element)){
                return index - 1;
            }
            index--;
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
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == size() - 1){
            return removeLast();
        }
        int i = 0;
        Node current = head;
        while (current != null){
            if (i == index){
                current.prev.next = current.next;
                current.next.prev = current.prev;
                return current.value;
            }
            i++;
            current = current.next;
        }
        // removing
        return null;
    }


    /**
     * Видаляє перший елемент списку
     * @return видаленний елемент
     */
    String removeFirst(){
        if (head == null){
            return null;
        }
        String headValue = head.value;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        return headValue;
    }

    /**
     * Видаляє останній елемент списку
     * @return видаленний елемент
     */
    String removeLast(){
        if (head == null) {
            return null;
        } else {
            String removedValue = tail.value;
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
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
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        Node current = head;
        while (current != null){
            if (i == index){
                break;
            }
            i++;
            current = current.next;
        }
        String prevValue = current.value;
        current.value = newValue;
        return prevValue;
    }

    /**
     * Додавання нового елементу за індексом;
     * @param element що хочете додати
     * @param index індекс нового елементу
     */
    void add(String element, int index){
        if (index == 0) {
            addFirst(element);
        } else if (index == size()) {
            addLast(element);
        } else {
            Node current = new Node();
            current.value = element;
            Node node = head;
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            current.next = node.next;
            current.prev = node;
            node.next.prev = current;
            node.next = current;
            /*
            K, Y, V, B, N P
            list.add(A, 3)
            K, Y, V, A, B, N P
             */
        }

    }

    /**
     * Додає новий елемент у початок списку
     * @param element елемент який ми хочемо додати
     */
    void addFirst(String element){
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

    /**
     * Видаляє всі елементи зі списку
     */
    void clear() {
        if (head == null){
            return;
        }
        Node current = head;
        while (current != null){
            Node next = current.next;
            current.prev = null;
            current.next = null;
            current = next;
        }
        head = null;
        tail = null;
    }

    /**
     * Робить копію списку
     * @param list список копію якого ми робимо
     * @return новий список (копію)
     */
    static LinkedList copyOf(LinkedList list) {
        LinkedList copyList = new LinkedList();
        if (list.isEmpty()){
            return copyList;
        }
        Node original = list.head;
        while (original != null){
            Node newNode = new Node();
            newNode.value = original.value;

            copyList.add(newNode.value);
            original = original.next;
        }
        return copyList;
    }

    /**
     * Обертає список
     * @return обернений список
     */
    public LinkedList reversed() {
        LinkedList reversedList = new LinkedList();
        Node current = tail;
        while (current != null){
            Node newNode = new Node();
            newNode.value = current.value;

            reversedList.add(newNode.value);
            current = current.prev;
        }
        return reversedList;
    }

    /**
     * Перевіряє чи міститься у списку заданий об'єкт
     * @param obj об'єкт який ми шукаємо
     * @return true or false
     */
    public boolean equals(Object obj) {
        /*
        1. Якщо адреси рівні, то обʼєкти точно рівні
        2. Якщо obj – це null, то вони різні
        3. Якщо obj – це не LinkedList, тоді вони точно різні
        4. Зробити порівняння списків
         */
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (!(obj instanceof LinkedList)) {
            return false;
        }
        LinkedList other = (LinkedList) obj;
        return this.isEqualTo(other);
    }

    /**
     * Перевіряє два списки на рівність
     * @param other список з яким порівнюємо
     * @return true or false
     */
    boolean isEqualTo(LinkedList other) {
        if (other == null || this.size() != other.size()) {
            return false;
        }

        Node currentList1 = head;
        Node currentList2 = other.head;
        while (currentList1 != null && currentList2 != null){
            if (!Objects.equals(currentList1.value, currentList2.value)){
                return false;
            }
            currentList1 = currentList1.next;
            currentList2 = currentList2.next;
        }
        return true;
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

    public LinkedList beggars(int n) {
        /*
        Solution plan:
        1) Main approach
        2) Exceptional case 1
        3) Exceptional case 2

        n = 2 – divide into 2 arrays
        {1, 3, 5} - sum ->
        {2, 4} ->
        result (sums array): {9, 6}
        n = 3 – divide into 3 arrays
        {1, 4}
        {2, 5}
        {3}
        result (sums array): {5, 7, 3}

        exceptional situations
        1) n > this.size()
        2) n == 0 -> return {}
         */
        LinkedList[] array = createArrayWithLists(n);
        if (n > this.size()) {
            // TODO: ...
        } else if (n == 0){
            return new LinkedList();
        } else {
            return _beggars(array, n);
        }
        return null;
    }

    private LinkedList _beggars(LinkedList[] groupLists, int n) {
        // int[] = 1, 2, 3, 4, 5, 6, 7, 8;
        int listIndex = 0;
        // head –> tail
        Node node = this.head;
        while (node != null) {
            groupLists[listIndex].add(node.value);
            node = node.next;
            if (listIndex == n){
                listIndex = 0;
            } else {
                listIndex ++;
            }
        }
        return _beggarsSums(groupLists);
    }

    private LinkedList _beggarsSums(LinkedList[] groupLists) {
        // TODO: порахувати суму для кожного списку в groupLists та зберегти цю суму в список sumList
        //       повернути список sumList
        return null;
    }

    private LinkedList[] createArrayWithLists(int n) {
        LinkedList[] array = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            array[i] = new LinkedList();
        }
        return array;
    }
}
