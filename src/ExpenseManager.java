import java.util.*; // Import utility classes including List, ArrayList, and Scanner

// Class representing a single transaction
class Transaction {
    String type;     // "income" or "expense"
    String category; // Category like Food, Rent, Salary, etc.
    double amount;   // Amount of the transaction
    String date;     // Date of transaction (format: YYYY-MM-DD)

    // Constructor to initialize a transaction
    public Transaction(String type, String category, double amount, String date) {
        this.type = type;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    // Override toString method to show a readable version of transaction
    @Override
    public String toString() {
        return "[" + date + "] " + type.toUpperCase() + " | " + category + " | " + amount + " Toman";
    }
}

// Main class for managing expenses
public class ExpenseManager {
    static List<Transaction> transactions = new ArrayList<>(); // List to store all transactions
    static Scanner scanner = new Scanner(System.in);           // Scanner to take user input

    // Main method - entry point of the application
    public static void main(String[] args) {
        while (true) { // Loop to show menu continuously until user exits
            System.out.println("\n--- Personal Expense Manager ---");
            System.out.println("1. Add Transaction");
            System.out.println("2. View All Transactions");
            System.out.println("3. View Summary");
            System.out.println("4. Search Transactions");
            System.out.println("5. Edit Transaction");
            System.out.println("6. Delete Transaction");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt(); // Read user's choice
            scanner.nextLine();             // Consume the leftover newline

            // Handle user's choice
            switch (choice) {
                case 1 -> addTransaction();       // Add new transaction
                case 2 -> viewTransactions();     // Show all transactions
                case 3 -> viewSummary();          // Show income, expense, and balance
                case 4 -> searchTransactions();   // Search by category or date
                case 5 -> editTransaction();      // Edit an existing transaction
                case 6 -> deleteTransaction();    // Delete a transaction
                case 7 -> {
                    System.out.println("Exiting...");
                    System.exit(0);              // Exit the program
                }
                default -> System.out.println("Invalid choice!"); // Handle invalid input
            }
        }
    }

    // Method to add a new transaction
    static void addTransaction() {
        System.out.print("Type (income/expense): ");
        String type = scanner.nextLine().trim().toLowerCase(); // Read and normalize type

        // Validate type
        if (!type.equals("income") && !type.equals("expense")) {
            System.out.println("❌ Invalid type. Must be 'income' or 'expense'.");
            return;
        }

        System.out.print("Category: ");
        String category = scanner.nextLine(); // Read category

        System.out.print("Amount: ");
        double amount = scanner.nextDouble(); // Read amount
        scanner.nextLine(); // Consume newline

        System.out.print("Date (YYYY-MM-DD): ");
        String date = scanner.nextLine(); // Read date

        // Create and add the transaction to the list
        transactions.add(new Transaction(type, category, amount, date));
        System.out.println("✅ Transaction added.");
    }

    // Method to view all transactions
    static void viewTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }

        // Display each transaction with its index
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println((i + 1) + ". " + transactions.get(i));
        }
    }

    // Method to show total income, expense and balance
    static void viewSummary() {
        double totalIncome = 0;
        double totalExpense = 0;

        // Loop through each transaction to calculate totals
        for (Transaction t : transactions) {
            if (t.type.equalsIgnoreCase("income")) totalIncome += t.amount;
            else if (t.type.equalsIgnoreCase("expense")) totalExpense += t.amount;
        }

        // Display summary
        System.out.println("💰 Total Income: " + totalIncome + " Toman");
        System.out.println("💸 Total Expense: " + totalExpense + " Toman");
        System.out.println("📊 Balance: " + (totalIncome - totalExpense) + " Toman");
    }

    // Method to search transactions by category or date
    static void searchTransactions() {
        System.out.print("Search by (category/date): ");
        String filter = scanner.nextLine().toLowerCase(); // Determine search type

        System.out.print("Enter value to search: ");
        String value = scanner.nextLine().toLowerCase(); // Get search keyword

        boolean found = false;

        // Loop and display matching transactions
        for (Transaction t : transactions) {
            if ((filter.equals("category") && t.category.toLowerCase().contains(value)) ||
                (filter.equals("date") && t.date.contains(value))) {
                System.out.println(t);
                found = true;
            }
        }

        if (!found) System.out.println("🔍 No matching transactions found.");
    }

    // Method to edit an existing transaction
    static void editTransaction() {
        viewTransactions(); // Show all to select from

        System.out.print("Enter transaction number to edit: ");
        int index = scanner.nextInt() - 1; // Get index (1-based input)
        scanner.nextLine(); // Consume newline

        // Check for valid index
        if (index < 0 || index >= transactions.size()) {
            System.out.println("❌ Invalid index.");
            return;
        }

        Transaction t = transactions.get(index); // Get selected transaction
        System.out.println("Editing: " + t);

        // Ask for new values; allow skipping by leaving empty
        System.out.print("New type (leave blank to keep '" + t.type + "'): ");
        String newType = scanner.nextLine().trim();
        if (!newType.isEmpty()) t.type = newType;

        System.out.print("New category (leave blank to keep '" + t.category + "'): ");
        String newCategory = scanner.nextLine().trim();
        if (!newCategory.isEmpty()) t.category = newCategory;

        System.out.print("New amount (or -1 to keep " + t.amount + "): ");
        double newAmount = scanner.nextDouble();
        scanner.nextLine();
        if (newAmount >= 0) t.amount = newAmount;

        System.out.print("New date (leave blank to keep '" + t.date + "'): ");
        String newDate = scanner.nextLine().trim();
        if (!newDate.isEmpty()) t.date = newDate;

        System.out.println("✅ Transaction updated.");
    }

    // Method to delete a transaction
    static void deleteTransaction() {
        viewTransactions(); // Show all to select from

        System.out.print("Enter transaction number to delete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        // Check for valid index
        if (index < 0 || index >= transactions.size()) {
            System.out.println("❌ Invalid index.");
            return;
        }

        // Remove from list
        transactions.remove(index);
        System.out.println("🗑️ Transaction deleted.");
    }
}