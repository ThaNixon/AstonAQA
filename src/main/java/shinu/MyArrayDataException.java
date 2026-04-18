package shinu;

public class MyArrayDataException extends Exception {
    int row;
    int col;
    public MyArrayDataException(int i, int j) {
        super("Ошибка в ячейке " + i + " " + j);
        this.row = i;
        this.col = j;
    }
}
