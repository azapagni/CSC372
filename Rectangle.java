public class Rectangle extends Shape {
    private double width;
    private double length;
    
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    //area formula
    @Override
    public double area() {
        return width * length;
    }

    //perimeter formula
    @Override
    public double perimeter() {
        return 2 * (width + length);
    }

    //final output
    @Override
    public String toString() {
        return "Rectangle - Area: " + area() + ", Perimeter: " + perimeter();
    }
}