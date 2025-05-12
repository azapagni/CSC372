public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    
    //area formula
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    //perimeter formula
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    //final output
    @Override
    public String toString() {
        return "Circle - Area: " + area() + ", Perimeter: " + perimeter();
    }
}