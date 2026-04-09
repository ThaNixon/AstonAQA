package shinu;

public class Circle implements Shape {
    double radius;
    String fillColor;
    String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
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
        return "Круг";
    }
}
