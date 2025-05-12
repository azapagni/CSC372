import java.util.Scanner;

public class ShapeArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //getting user input for triangle
        System.out.println("Please enter the dimensions of the triangle:");
        System.out.print("Side 1: ");
        double side1 = scanner.nextDouble();
        System.out.print("Side 2: ");
        double side2 = scanner.nextDouble();
        System.out.print("Side 3: ");
        double side3 = scanner.nextDouble();
        Triangle triangle = new Triangle(side1, side2, side3);

        //getting user input for circle
        System.out.println("\nPlease enter the dimensions of the circle:");
        System.out.print("Radius: ");
        double radius = scanner.nextDouble();
        Circle circle = new Circle(radius);

        //getting user input for square
        System.out.println("\nPlease enter the dimensions of the square:");
        System.out.print("Side length: ");
        double sideLength = scanner.nextDouble();
        Rectangle square = new Rectangle(sideLength, sideLength);

        //putting input into array
        Shape[] shapeArray = {triangle, circle, square};

        //final output
        System.out.println("\nShape Information:");
        System.out.println("--------------------");
        for (Shape shape : shapeArray) {
            System.out.println(shape.toString());
        }
        scanner.close();
    }
}