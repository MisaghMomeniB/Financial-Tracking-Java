import java.util.*;
import java.io.*;

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
                case 1: addTransaction(); break;
                case 2: viewTransactions(); break;
                case 3: viewSummary(); break;
                case 4: System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }