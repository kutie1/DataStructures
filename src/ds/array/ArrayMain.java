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
    public static void main(String[] args) {
        int[] arr1 = {2, 6, 4, 3, 9, 10};
        int[] arr2 = arr1.clone();
        arr2[0] = 99;
        System.out.println("arr1 = " + Arrays.toString(arr1));
        System.out.println("arr2 = " + Arrays.toString(arr2));


    }
}
