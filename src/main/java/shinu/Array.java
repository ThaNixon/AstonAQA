package shinu;

public class Array {
    public int sum(String[][] arr) throws  MyArraySizeException, MyArrayDataException {
        int totalSum = 0;

        if (arr.length != 4) {
            throw new MyArraySizeException("В массиве должно быть 4 строки.");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException("В строке " + i + " должно быть 4 столбца.");
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    totalSum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return totalSum;
    }
}
