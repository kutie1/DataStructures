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
