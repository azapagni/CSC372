public class CheckingAccount extends BankAccount {
    private double interestRate;
    private final double OVERDRAFT_FEE = 30.0;
    
    // Constructor
    public CheckingAccount() {
        super();
        interestRate = 0.0;
    }
    
    // Constructor with parameters
    public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
        super(firstName, lastName, accountID);
        this.interestRate = interestRate;
    }
    
    // Getter and setter for interest rate
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    
    public double getInterestRate() {
        return interestRate;
    }
    
    // Process withdrawal with overdraft fee
    public void processWithdrawal(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. Amount must be positive.");
            return;
        }
        
        if (amount > getBalance()) {
            // Overdraft occurs
            withdrawal(amount); // Use the withdrawal method from parent class
            withdrawal(OVERDRAFT_FEE); // Charge the overdraft fee
            System.out.println("Overdraft! A fee of $" + OVERDRAFT_FEE + " has been assessed.");
            System.out.println("Current balance after overdraft fee: $" + getBalance());
        } else {
            // Normal withdrawal
            withdrawal(amount);
        }
    }
    
    // Display account information
    public void displayAccount() {
        accountSummary(); // Call the superclass method
        System.out.println("Interest Rate: " + (interestRate * 100) + "%");
    }
}