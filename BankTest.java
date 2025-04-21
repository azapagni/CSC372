import java.util.Scanner;

public class BankTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== BANK ACCOUNT TESTING SYSTEM =====");
        
        // Test regular bank account
        testBankAccount(scanner);
        
        // Test checking account
        testCheckingAccount(scanner);
        
        System.out.println("\nThank you for using the Bank Account Testing System!");
        scanner.close();
    }
    
     //Tests the functionality of a regular bank account
    private static void testBankAccount(Scanner scanner) {
        System.out.println("\n===== Testing Regular Bank Account =====");
        
        // Get account details
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        
        System.out.print("Enter account ID: ");
        int accountID = getIntInput(scanner);
        scanner.nextLine(); // Clear buffer
        
        // Create the account
        BankAccount account = new BankAccount(firstName, lastName, accountID);
        System.out.println("Account created successfully!");
        
        // Test deposit
        System.out.print("\nEnter amount to deposit: $");
        double depositAmount = getDoubleInput(scanner);
        scanner.nextLine(); // Clear buffer
        account.deposit(depositAmount);
        
        // Test withdrawal
        System.out.print("\nEnter amount to withdraw: $");
        double withdrawAmount = getDoubleInput(scanner);
        scanner.nextLine(); // Clear buffer
        account.withdrawal(withdrawAmount);
        
        // Display account summary
        System.out.println("\nFinal account summary:");
        account.accountSummary();
    }
    
     //Tests the functionality of a checking account
     
    private static void testCheckingAccount(Scanner scanner) {
        System.out.println("\n===== Testing Checking Account =====");
        
        // Get account details
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        
        System.out.print("Enter account ID: ");
        int accountID = getIntInput(scanner);
        scanner.nextLine(); // Clear buffer
        
        System.out.print("Enter interest rate (decimal format, e.g., 0.02 for 2%): ");
        double interestRate = getDoubleInput(scanner);
        scanner.nextLine(); // Clear buffer
        
        // Create the checking account
        CheckingAccount checkingAccount = new CheckingAccount(firstName, lastName, accountID, interestRate);
        System.out.println("Checking account created successfully!");
        
        // Deposit funds
        System.out.print("\nEnter amount to deposit: $");
        double depositAmount = getDoubleInput(scanner);
        scanner.nextLine(); // Clear buffer
        checkingAccount.deposit(depositAmount);
        
        // Test regular withdrawal
        System.out.print("\nEnter first withdrawal amount: $");
        double withdrawAmount1 = getDoubleInput(scanner);
        scanner.nextLine(); // Clear buffer
        checkingAccount.processWithdrawal(withdrawAmount1);
        
        // Test potential overdraft
        System.out.print("\nEnter second withdrawal amount (to test overdraft): $");
        double withdrawAmount2 = getDoubleInput(scanner);
        scanner.nextLine(); // Clear buffer
        checkingAccount.processWithdrawal(withdrawAmount2);
        
        // Display account information
        System.out.println("\nFinal checking account status:");
        checkingAccount.displayAccount();
    }
    
     //Helper method to get valid integer input
    private static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            scanner.next(); // Clear invalid input
        }
        return scanner.nextInt();
    }
    
     //Helper method to get valid double input
    private static double getDoubleInput(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            scanner.next(); // Clear invalid input
        }
        return scanner.nextDouble();
    }
}