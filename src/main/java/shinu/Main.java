package shinu;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(5, "Красный", "Чёрный"),
                new Rectangle(5, 4, "Красный", "Чёрный"),
                new Triangle(3, 4, 5, "Красный", "Чёрный")
        };
        for (Shape shape : shapes) {
            shape.printInfo();
        }
    }
}