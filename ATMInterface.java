//ATM INTERFACE
//1.Create a class to represent the ATM machine.
//
//        2. Design the user interface for the ATM, including options such as withdrawing, depositing, and
//checking the balance.
//
//3. Implement methods for each option, such as withdraw(amount), deposit(amount), and
//checkBalance().
//
//        4. Create a class to represent the user's bank account, which stores the account balance.
//
//        5. Connect the ATM class with the user's bank account class to access and modify the account
//balance.
//
//6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).
//
//        7. Display appropriate messages to the user based on their chosen options and the success or failure
//of their transactions.
//




import java.util.*;

// Class representing the user's bank account
class BankAccount {
    private double balance;
    private final String pin;
    private final List<String> transactionHistory;

    // Constructor to initialize balance and PIN
    public BankAccount(double initialBalance, String pin) {
        this.balance = initialBalance;
        this.pin = pin;
        this.transactionHistory = new ArrayList<>();
    }

    // Method to check if entered PIN is correct
    public boolean verifyPin(String inputPin) {
        return pin.equals(inputPin);
    }

    // Method to deposit amount
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: ₹" + amount);
            System.out.println("Deposit successful! New balance: ₹" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw amount
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                transactionHistory.add("Withdrew: ₹" + amount);
                System.out.println("Withdrawal successful! New balance: ₹" + balance);
            } else {
                System.out.println("Insufficient balance.");
                transactionHistory.add("Failed Withdrawal (Insufficient funds): ₹" + amount);
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to check balance
    public double getBalance() {
        transactionHistory.add("Checked Balance: ₹" + balance);
        return balance;
    }

    // Method to show transaction history
    public void printTransactionHistory() {
        System.out.println("\n===== Transaction History =====");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }
}

// Class representing the ATM Machine
class ATM {
    private final BankAccount account;

    // Constructor that takes a BankAccount object
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method to start the ATM UI and handle user input
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n Wellcome to Biswajit's Bank !!\n");
        // Authenticate user by PIN
        System.out.print("\nEnter your 4-digit PIN: ");
        String inputPin = scanner.nextLine();

        if (!account.verifyPin(inputPin)) {
            System.out.println("Incorrect PIN. Access denied.");
            return;
        }

        int choice = -1;

        do {
            // Display the menu
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            // Input validation for menu choice
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Your current balance is: ₹" + account.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ₹");
                        if (scanner.hasNextDouble()) {
                            double depositAmount = scanner.nextDouble();
                            account.deposit(depositAmount);
                        } else {
                            System.out.println("Invalid amount. Please enter a numeric value.");
                            scanner.next(); // Clear invalid input
                        }
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ₹");
                        if (scanner.hasNextDouble()) {
                            double withdrawAmount = scanner.nextDouble();
                            account.withdraw(withdrawAmount);
                        } else {
                            System.out.println("Invalid amount. Please enter a numeric value.");
                            scanner.next(); // Clear invalid input
                        }
                        break;
                    case 4:
                        account.printTransactionHistory();
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM! \n Have a Good Day!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 5.");
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // Clear invalid input
            }

        } while (choice != 5);

        scanner.close();
    }
}

// Main class
public class ATMInterface {
    public static void main(String[] args) {
        // Create a BankAccount with initial balance ₹1000 and PIN "1234"
        BankAccount userAccount = new BankAccount(1000.0, "1234");

        // Create an ATM object and pass the user account
        ATM atm = new ATM(userAccount);

        // Start the ATM interface
        atm.start();
    }
}
