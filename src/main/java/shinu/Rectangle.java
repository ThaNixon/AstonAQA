package shinu;

public class Rectangle implements Shape {
    double width;
    double height;
    String fillColor;
    String borderColor;

    public Rectangle(double width, double height,  String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    @Override
    public double getArea() {
        return width * height;
    }
    @Override
    public double getPerimeter() {
        return 2*(width + height);
    }
    @Override
    public String getFillColor(){
        return fillColor;
    }
    @Override
    public String getBorderColor(){
        return borderColor;
    }
    @Override
    public String getTypeName() {
        return "Прямоугольник";
    }
}
