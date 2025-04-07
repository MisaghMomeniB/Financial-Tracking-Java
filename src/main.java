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