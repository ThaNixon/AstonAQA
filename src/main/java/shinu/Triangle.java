package shinu;

public class Triangle implements Shape {
    double side1, side2, side3;
    String fillColor;
    String borderColor;

    public Triangle(double side1, double side2, double side3,  String fillColor, String borderColor) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    @Override
    public double getArea() {
        double p = (side1+side2+side3)/2;
        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }
    @Override
    public double getPerimeter() {
        return side1+side2+side3;
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
        return "Треугольник";
    }
}
