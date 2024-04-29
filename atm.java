import java.util.Scanner;

public class ATM {
    private BankAccount userAccount;
    
    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }
    
    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }
    
    public void performAction(int choice) {
        switch (choice) {
            case 1:
                withdraw();
                break;
            case 2:
                deposit();
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        
        if (userAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
    
    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        userAccount.deposit(amount);
        System.out.println("Deposit successful.");
    }
    
    public void checkBalance() {
        System.out.println("Your current balance is: " + userAccount.getBalance());
    }
    
    public static void main(String[] args) {
        // Create a bank account for the user
        BankAccount userAccount = new BankAccount();
        userAccount.setBalance(1000); // Set initial balance
        
        ATM atm = new ATM(userAccount);
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            atm.performAction(choice);
        }
    }
}

class BankAccount {
    private double balance;
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
    
    public void deposit(double amount) {
        balance += amount;
    }
}
