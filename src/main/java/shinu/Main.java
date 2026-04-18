package shinu;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "Привет", "2", "3"},
                {"4", "5", "6", "7"}
        };
        Array array = new Array();
        try
            {
                int result = array.sum(arr);
                System.out.println("Сумма: " + result);
            }
        catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Произошла ошибка : " + e.getMessage());
        }

        System.out.println("-----------------");

        int[] small = {1,2};
        try {
            System.out.println(small[4]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("За пределами массива!");
        }
    }
}