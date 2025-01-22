import java.util.Scanner;

public class BankingApplication {

    private static double balance = 0.0; // Stores the user's account balance
    private static final Scanner scanner = new Scanner(System.in); // For user input

    public static void main(String[] args) {
        System.out.println("=== Welcome to Simple Banking Application ===");

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> depositMoney();
                case 2 -> withdrawMoney();
                case 3 -> checkBalance();
                case 4 -> {
                    isRunning = false;
                    System.out.println("Thank you for using the banking application. Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void depositMoney() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited $%.2f. Your new balance is $%.2f.%n", amount, balance);
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    private static void withdrawMoney() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Successfully withdrew $%.2f. Your new balance is $%.2f.%n", amount, balance);
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Please try a smaller amount.");
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    private static void checkBalance() {
        System.out.printf("Your current balance is $%.2f.%n", balance);
    }
}
