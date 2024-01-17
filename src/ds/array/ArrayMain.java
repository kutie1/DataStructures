package ds.array;

import java.util.Arrays;

class Car {
    // instance method
    void run() {
        System.out.println("🚗💨");
    }

    // static method (class method)
    static void showCarHistory() {
        System.out.println("The first car has been created at ...");
    }
}

public class ArrayMain {


    /**
     * Перевіряє чи присутній елемент зі значенням
     * key у відсортованому масиві arr
     */
    static boolean binarySearch(int[] arr, int key) {
        // TODO: binarySearch() – test speed
        if (arr.length == 0) {
            return false;
        }
        if (arr[0] == key || arr[arr.length - 1] == key) {
            return true;
        }
        int from = 0;
        int to = arr.length - 1;
        int middle = (from + to) / 2;
        while (true) {
            if (arr[middle] == key){
                return true;
            } else if (arr[middle] > key){
                to = middle;
            } else {
                from = middle;
            }
            middle = (from + to) / 2;
            // якщо middle – це початок або кінець (from or to), то потрібно зупинити пошук
            if (middle == from || middle == to){
                break;
            }
        }
        return false;
    }

    static int[] copyOf(int[] original, int newLength) {
        // TODO: copyOf() – реалізувати цей метод так, як описано в документації
        //   + test()
        return null;
    }

    static int[] copyOfRange(int[] original, int from, int to) {
        // TODO: copyOfRange() – реалізувати цей метод так, як описано в документації
        //        //   + test()
        return null;
    }


    public static void main(String[] args) {

        // TODO: byte datatype

        int age = 32;
        int[] arr = {10, 9, 8, 7};
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
        String[][] matrix = new String[3][3];
        // matrix = {null, null, null}
        // matrix = {address_row_1,
        //           address_row_2,
        //           address_row_3}
        for (int i = 0; i < matrix.length; ++i) {
            String[] row = new String[3];
            Arrays.fill(row, "u");
            matrix[i] = row;
        }
        String deepText = Arrays.deepToString(matrix);
        String text = Arrays.toString(matrix);
//        System.out.println("text = " + text);
//        System.out.println("deepText = " + deepText);

        // setAll
        Random random = new Random();
        arr = new int[5];
        Arrays.setAll(arr, index -> random.nextInt(1, 11));
//        System.out.println(Arrays.toString(arr));
    }
}
