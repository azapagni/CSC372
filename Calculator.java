import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        
        System.out.println("Enter five numbers: ");
        
        for (int i = 0; i < 5; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }
        
        int sum = calculateSum(numbers, 0);
        
        System.out.println("The sum of all five numbers is: " + sum);
        
        scanner.close();
    }

    public static int calculateSum(int[] numbers, int index) {
        if (index >= numbers.length) {
            return 0;
        }
        
        return numbers[index] + calculateSum(numbers, index + 1);
    }
}