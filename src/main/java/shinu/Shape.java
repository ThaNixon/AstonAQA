package shinu;

public interface Shape {
    double getArea();
    double getPerimeter();
    String getFillColor();
    String getBorderColor();
    String getTypeName();

    default void printInfo(){
        System.out.println("Фигура: " + getTypeName());
        System.out.println("Площадь: " + getArea());
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Цвет фона: " + getFillColor());
        System.out.println("Цвет границ: " + getBorderColor());
        System.out.println("-------------");
    }
}
