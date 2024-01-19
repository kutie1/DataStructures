package algo;


import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

// TODO: ~Implement comparison with one base interface
public class BinarySearch {
    Random random = new Random();

    static class Counter {
        private int count = 0;

        void increase() {
            this.count += 1;
        }

        public int getCount() {
            return count;
        }

        @Override
        public String toString() {
            return String.valueOf(this.count);
        }

        public void reset() {
            this.count = 0;
        }
    }

    /**
     * Перевіряє чи присутній елемент зі значенням
     * key у відсортованому масиві arr
     */
    boolean binarySearch(int[] arr, int key, Counter count) {
        count.increase();
        if (key < arr[0] || key > arr[arr.length - 1]) {
            return false;
        }
        count.increase();
        if (arr.length == 0) {

            return false;
        }
        count.increase();
        if (arr[0] == key || arr[arr.length - 1] == key) {
            return true;
        }
        count.increase();
        int from = 0;
        int to = arr.length - 1;
        int middle = (from + to) / 2;
        while (true) {
            count.increase();
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

    /**
     * Перебирає кожен елемент
     */
    boolean linearSearch(int[] arr, int key, Counter count) {
        // N elements
        for (int a : arr){
            count.increase();
            if (a == key){
                return true;
            }
        }
        return false;
    }

    int[] randomSortedArray(int length, int bound){
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(0, bound);
        }
        Arrays.sort(arr);
        return arr;
    }

    boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]){
                return false;
            }
        }
        return true;
    }

    int randomNumIsContainsInArr(int[] arr){
        return arr[random.nextInt(arr.length)];
    }

    int getRandomNum(){
        int negative = random.nextInt(-1_000_000, 0);
        int positive = random.nextInt(1_000_000,3_000_000);
        return random.nextBoolean() ? positive : negative;
    }

    void compareForAnArray(int[] arr) {
        // шукаємо кожен раз 20 різних рандомних елементів із масиву та 20 різних рандомних, яких немає в масиві
        // кожен раз заміряти кількість порівнянь та для кожного методу визначити середню к-сть порівнянь
        // вивести цю інформацію на екран
        Counter counter = new Counter();
        int binaryCount = 0;
        List<Integer> binaryCountsList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int randomNum = randomNumIsContainsInArr(arr);
            binarySearch(arr, randomNum, counter);
            binaryCount = counter.getCount();
            binaryCountsList.add(binaryCount);
            counter.reset();
        }
        for (int i = 0; i < 20; i++) {
            int randomNum = getRandomNum();
            binarySearch(arr, randomNum, counter);
            binaryCount = counter.getCount();
            binaryCountsList.add(binaryCount);
            counter.reset();
        }
        double sumBinary = 0;
        for(int a : binaryCountsList){
            sumBinary += a;
        }
        double averageBinary = sumBinary / binaryCountsList.size();

        int linearCount = 0;
        List<Integer> linearCountsList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int randomNum = randomNumIsContainsInArr(arr);
            linearSearch(arr, randomNum, counter);
            linearCount = counter.getCount();
            linearCountsList.add(linearCount);
            counter.reset();
        }
        for (int i = 0; i < 20; i++) {
            int randomNum = getRandomNum();
            linearSearch(arr, randomNum, counter);
            linearCount = counter.getCount();
            linearCountsList.add(linearCount);
            counter.reset();
        }
        double sumLinear = 0;
        for(int a : linearCountsList){
            sumLinear += a;
        }
        double averageLinear = sumLinear / linearCountsList.size();
        String strArrLength = NumberFormat.getNumberInstance().format(arr.length);
        String strAverageBinary = NumberFormat.getNumberInstance().format(averageBinary);
        String strAverageLinear = NumberFormat.getNumberInstance().format(averageLinear);

        System.out.println("Для масива з " + arr.length + " кількістю елементів\n" +
                "Бінарному пошуку потрібно в середньому " + averageBinary + " перевірок.");
        System.out.println("Для масива з " + arr.length + " кількістю елементів\n" +
                "Лінійному пошуку потрібно в середньому " + averageLinear + " перевірок.");


    }

    @Test
    void compareSpeed() {
        int[] arr0 = {1, 2, 3, 4, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Random random = new Random();
        int[] arr1 = randomSortedArray(100, 1000);
        int[] arr2 = randomSortedArray(500, 1_000_000);
        int[] arr3 = randomSortedArray(2093, 1_000_000);
        int[] arr4 = randomSortedArray(8093, 1_000_000);
        int[] arr5 = randomSortedArray(20000, 1_000_000);
        int[] arr6 = randomSortedArray(700690, 1_000_000);
        int[] arr7 = randomSortedArray(210789, 1_000_000);
        int[] arr8 = randomSortedArray(700789, 1_000_000);
        compareForAnArray(arr0);
        compareForAnArray(arr1);
        compareForAnArray(arr2);
        compareForAnArray(arr3);
        compareForAnArray(arr4);
        compareForAnArray(arr5);
        compareForAnArray(arr6);
        compareForAnArray(arr7);
        compareForAnArray(arr8);
    }

    public static void main(String[] args) {
        new BinarySearch().compareSpeed();
    }
}
