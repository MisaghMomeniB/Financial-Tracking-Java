import java.util.*;

// Class representing a single transaction
class Transaction {
    String type;
    String category;
    double amount;
    String date;

    public Transaction(String type, String category, double amount, String date) {
        this.type = type;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return "[" + date + "] " + type.toUpperCase() + " | " + category + " | " + amount + " Toman";
    }
}

// Main class to manage expenses
public class ExpenseManager {
    static List<Transaction> transactions = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Personal Expense Manager ---");
            System.out.println("1. Add Transaction");
            System.out.println("2. View All Transactions");
            System.out.println("3. View Summary");
            System.out.println("4. Search Transactions");
            System.out.println("5. Edit Transaction");
            System.out.println("6. Delete Transaction");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addTransaction();
                case 2 -> viewTransactions();
                case 3 -> viewSummary();
                case 4 -> searchTransactions();
                case 5 -> editTransaction();
                case 6 -> deleteTransaction();
                case 7 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addTransaction() {
        System.out.print("Type (income/expense): ");
        String type = scanner.nextLine().trim().toLowerCase();
        if (!type.equals("income") && !type.equals("expense")) {
            System.out.println("❌ Invalid type. Must be 'income' or 'expense'.");
            return;
        }

        System.out.print("Category: ");
        String category = scanner.nextLine();

        System.out.print("Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        transactions.add(new Transaction(type, category, amount, date));
        System.out.println("✅ Transaction added.");
    }

    static void viewTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }

        for (int i = 0; i < transactions.size(); i++) {
            System.out.println((i + 1) + ". " + transactions.get(i));
        }
    }

    static void viewSummary() {
        double totalIncome = 0, totalExpense = 0;
        for (Transaction t : transactions) {
            if (t.type.equalsIgnoreCase("income")) totalIncome += t.amount;
            else if (t.type.equalsIgnoreCase("expense")) totalExpense += t.amount;
        }
        System.out.println("💰 Total Income: " + totalIncome + " Toman");
        System.out.println("💸 Total Expense: " + totalExpense + " Toman");
        System.out.println("📊 Balance: " + (totalIncome - totalExpense) + " Toman");
    }

    static void searchTransactions() {
        System.out.print("Search by (category/date): ");
        String filter = scanner.nextLine().toLowerCase();

        System.out.print("Enter value to search: ");
        String value = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (Transaction t : transactions) {
            if ((filter.equals("category") && t.category.toLowerCase().contains(value)) ||
                (filter.equals("date") && t.date.contains(value))) {
                System.out.println(t);
                found = true;
            }
        }

        if (!found) System.out.println("🔍 No matching transactions found.");
    }

    static void editTransaction() {
        viewTransactions();
        System.out.print("Enter transaction number to edit: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index < 0 || index >= transactions.size()) {
            System.out.println("❌ Invalid index.");
            return;
        }

        Transaction t = transactions.get(index);
        System.out.println("Editing: " + t);

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

    static void deleteTransaction() {
        viewTransactions();
        System.out.print("Enter transaction number to delete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index < 0 || index >= transactions.size()) {
            System.out.println("❌ Invalid index.");
            return;
        }

        transactions.remove(index);
        System.out.println("🗑️ Transaction deleted.");
    }
}