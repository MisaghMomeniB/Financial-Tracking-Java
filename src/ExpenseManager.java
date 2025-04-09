import java.util.*; // Importing all utility classes including List, ArrayList, and Scanner

// Class representing a single transaction
class Transaction {
    String type; // "income" or "expense"
    String category; // Category of the transaction (e.g., Food, Rent)
    double amount; // Amount of the transaction
    String date; // Date of the transaction

    // Constructor to initialize transaction details
    public Transaction(String type, String category, double amount, String date) {
        this.type = type;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    // Method to convert a transaction to a readable string format
    @Override
    public String toString() {
        return "[" + date + "] " + type.toUpperCase() + " | " + category + " | " + amount + " Toman";
    }
}

// Main class to manage expenses
public class ExpenseManager {
    static List<Transaction> transactions = new ArrayList<>(); // List to store all transactions
    static Scanner scanner = new Scanner(System.in); // Scanner for user input

    // Main method - program entry point
    public static void main(String[] args) {
        while (true) { // Infinite loop to keep showing the menu until the user exits
            System.out.println("\n--- Personal Expense Manager ---");
            System.out.println("1. Add Transaction"); // Option to add a new transaction
            System.out.println("2. View All Transactions"); // Option to view all transactions
            System.out.println("3. View Summary"); // Option to view summary (income/expense/balance)
            System.out.println("4. Exit"); // Option to exit the program
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt(); // Read user's choice
            scanner.nextLine(); // Flush the newline character

            // Switch case based on user's input
            switch (choice) {
                case 1 -> addTransaction(); // Add a new transaction
                case 2 -> viewTransactions(); // Show all transactions
                case 3 -> viewSummary(); // Show financial summary
                case 4 -> { // Exit case
                    System.out.println("Exiting...");
                    System.exit(0); // Terminate the program
                }
                default -> System.out.println("Invalid choice!"); // Handle invalid input
            }
        }
    }

    // Method to add a transaction
    static void addTransaction() {
        System.out.print("Type (income/expense): ");
        String type = scanner.nextLine(); // Read the transaction type

        System.out.print("Category (e.g. Food, Rent, Salary): ");
        String category = scanner.nextLine(); // Read the transaction category

        System.out.print("Amount: ");
        double amount = scanner.nextDouble(); // Read the transaction amount
        scanner.nextLine(); // Flush the newline character

        System.out.print("Date (e.g. 2025-04-07): ");
        String date = scanner.nextLine(); // Read the date of the transaction

        Transaction t = new Transaction(type, category, amount, date); // Create new transaction object
        transactions.add(t); // Add transaction to the list

        System.out.println("✅ Transaction added."); // Confirmation message
    }

    // Method to display all transactions
    static void viewTransactions() {
        if (transactions.isEmpty()) { // Check if there are no transactions
            System.out.println("No transactions yet.");
            return;
        }

        for (Transaction t : transactions) { // Loop through and print each transaction
            System.out.println(t);
        }
    }

    // Method to display income, expenses, and balance
    static void viewSummary() {
        double totalIncome = 0; // Variable to store total income
        double totalExpense = 0; // Variable to store total expenses

        for (Transaction t : transactions) { // Loop through transactions
            if (t.type.equalsIgnoreCase("income")) { // If transaction is income
                totalIncome += t.amount;
            } else if (t.type.equalsIgnoreCase("expense")) { // If transaction is expense
                totalExpense += t.amount;
            }
        }

        // Print income, expenses, and remaining balance
        System.out.println("💰 Total Income: " + totalIncome + " Toman");
        System.out.println("💸 Total Expense: " + totalExpense + " Toman");
        System.out.println("📊 Balance: " + (totalIncome - totalExpense) + " Toman");
    }
}