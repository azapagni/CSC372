public class BankAccount {
    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;
    
    // Constructor
    public BankAccount() {
        balance = 0.0;
    }
    
    // Constructor with parameters
    public BankAccount(String firstName, String lastName, int accountID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountID = accountID;
        this.balance = 0.0;
    }
    
    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Amount must be positive.");
        }
    }
    
    // Withdrawal method
    public void withdrawal(double amount) {
        if (amount > 0) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount. Amount must be positive.");
        }
    }
    
    // Setters and getters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
    
    public int getAccountID() {
        return accountID;
    }
    
    public double getBalance() {
        return balance;
    }
    
    // Account summary
    public void accountSummary() {
        System.out.println("Account Summary:");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Account ID: " + accountID);
        System.out.println("Balance: $" + balance);
    }
}
