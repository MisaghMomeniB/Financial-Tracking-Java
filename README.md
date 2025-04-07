# 💰 Personal Expense Manager

A simple Java application to track your income and expenses, helping you manage your personal finances effectively.

## 🚀 Features

- ➕ Add transactions (income/expense) with categories
- 📜 View all transactions in a clean list
- 📊 See financial summary (total income, expenses, and balance)
- 📅 Track transactions by date
- 💾 In-memory storage (transactions persist during current session)

## 🛠️ How It Works

### 🔧 Prerequisites
- Java JDK 8 or later
- Basic terminal knowledge

### ⬇️ Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/personal-expense-manager.git
   ```
2. Navigate to the project directory:
   ```bash
   cd personal-expense-manager
   ```
3. Compile the Java file:
   ```bash
   javac ExpenseManager.java
   ```

### ▶️ Running the Application
```bash
java ExpenseManager
```

## 🖥️ Usage
1. **Main Menu**:
   ```
   --- Personal Expense Manager ---
   1. Add Transaction
   2. View All Transactions
   3. View Summary
   4. Exit
   ```

2. **Adding a Transaction**:
   - Choose type (`income` or `expense`)
   - Enter a category (e.g., Food, Rent, Salary)
   - Input the amount
   - Add the date in `YYYY-MM-DD` format

3. **Viewing Transactions**:
   - See all transactions displayed with:
     - Date
     - Type (INCOME/EXPENSE)
     - Category
     - Amount

4. **Viewing Summary**:
   - Shows:
     - 💰 Total Income
     - 💸 Total Expenses
     - 📊 Current Balance

## 📝 Example Transaction
```
[2025-04-07] INCOME | Salary | 5000000 Toman
[2025-04-07] EXPENSE | Food | 150000 Toman
```

## 📈 Future Enhancements
- 🔄 Persistent storage (save to file/database)
- 📆 Monthly/yearly reports
- 📊 Graphical charts for visualization
- 🔍 Filtering/sorting transactions
- 🏷️ Custom category management

## 🤝 Contributing
Pull requests are welcome! For major changes, please open an issue first to discuss what you'd like to change.
