import java.util.*;

class Transaction {
    String type; // "income" or "expense"
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

public class ExpenseManager {
    static List<Transaction> transactions = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Personal Expense Manager ---");
            System.out.println("1. Add Transaction");
            System.out.println("2. View All Transactions");
            System.out.println("3. View Summary");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // flush

            switch (choice) {
                case 1 -> addTransaction();
                case 2 -> viewTransactions();
                case 3 -> viewSummary();
                case 4 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addTransaction() {
        System.out.print("Type (income/expense): ");
        String type = scanner.nextLine();

        System.out.print("Category (e.g. Food, Rent, Salary): ");
        String category = scanner.nextLine();

        System.out.print("Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Date (e.g. 2025-04-07): ");
        String date = scanner.nextLine();

        Transaction t = new Transaction(type, category, amount, date);
        transactions.add(t);

        System.out.println("✅ Transaction added.");
    }

    static void viewTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }

        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    static void viewSummary() {
        double totalIncome = 0;
        double totalExpense = 0;

        for (Transaction t : transactions) {
            if (t.type.equalsIgnoreCase("income")) {
                totalIncome += t.amount;
            } else if (t.type.equalsIgnoreCase("expense")) {
                totalExpense += t.amount;
            }
        }

        System.out.println("💰 Total Income: " + totalIncome + " Toman");
        System.out.println("💸 Total Expense: " + totalExpense + " Toman");
        System.out.println("📊 Balance: " + (totalIncome - totalExpense) + " Toman");
    }
}