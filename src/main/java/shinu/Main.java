package shinu;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Тест 1: printThreeWords ---");
        printThreeWords();

        System.out.println("\n--- Тест 2: checkSumSign ---");
        checkSumSign();

        System.out.println("\n--- Тест 3: printColor ---");
        printColor();

        System.out.println("\n--- Тест 4: compareNumbers ---");
        compareNumbers();

        System.out.println("\n--- Тест 5: checkSumInLimit ---");
        System.out.println(checkSumInLimit(11, 19));

        System.out.println("\n--- Тест 6: checkPositive ---");
        checkPositive(0);

        System.out.println("\n--- Тест 7: checkNegative ---");
        System.out.println(checkNegative(0));

        System.out.println("\n--- Тест 8: printString ---");
        printString("Hello World!", 5);

        System.out.println("\n--- Тест 9: isLeapYear ---");
        System.out.println(isLeapYear(2104));

        System.out.println("\n--- Тест 10: invertArray ---");
        int[] myArray = {1, 0, 1, 0, 0, 1, 1, 0, 1, 1};
        System.out.println("До инвертирования: " + Arrays.toString(myArray));
        invertArray(myArray);
        System.out.println("После инвертирования: " + Arrays.toString(myArray));

        System.out.println("\n--- Тест 11: fillArray ---");
        fillArray();

        System.out.println("\n--- Тест 12: multiplyArray ---");
        int[] multiplyArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("До умножения: " + Arrays.toString(multiplyArray));
        multiplyArray(multiplyArray);
        System.out.println("После умножения: " + Arrays.toString(multiplyArray));

        System.out.println("\n--- Тест 13: doubleArray ---");
        doubleArray();

        System.out.println("\n--- Тест 14: createArray ---");
        System.out.println(Arrays.toString(createArray(5, 4)));
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");

    }

    public static void checkSumSign() {
        int a = 10;
        int b = 1;

        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = -10;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Жёлтый");

        } else {
            System.out.println("Зелёный");
        }
    }

    public static void compareNumbers() {
        int a = 10;
        int b = 15;

        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }
    }

    public static boolean checkSumInLimit(int a, int b) {
        int sum = a + b;

        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void checkPositive(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean checkNegative(int a) {

        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void printString(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    public static boolean isLeapYear(int year) {
        return  (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void invertArray (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else  {
                arr[i] = 0;
            }
        }
    }

    public static void fillArray() {
        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
    System.out.println(Arrays.toString(arr));
    }

    public static void multiplyArray (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
    }

    public static void doubleArray () {
        int[][] arr = new int[5][5];
        int lastIndex = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
           arr[i][i] = 1;
           arr[i][lastIndex - i] = 1;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static int[] createArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
}