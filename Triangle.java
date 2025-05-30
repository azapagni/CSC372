public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    //area formula
    @Override
    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s * side3));
    }

    //perimeter formula
    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }

    //final output
    @Override
    public String toString() {
        return "Triangle - Area: " + area() +", Perimeter: " + perimeter();
    }
}