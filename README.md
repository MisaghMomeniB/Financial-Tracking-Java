# 💰 Financial Tracking (Java)

A Java console and Swing-based **personal finance tracker** for managing incomes, expenses, and viewing financial summaries. Designed for simple financial monitoring and improvement.

---

## 📋 Table of Contents

1. [Overview](#overview)  
2. [Features](#features)  
3. [Tech Stack & Dependencies](#tech-stack--dependencies)  
4. [Database & Structure](#database--structure)  
5. [Installation & Setup](#installation--setup)  
6. [Usage](#usage)  
7. [Code Structure](#code-structure)  
8. [Future Enhancements](#future-enhancements)  
9. [Contributing](#contributing)  
10. [License](#license)

---

## 💡 Overview

This application allows users to track and categorize financial transactions—both income and expenses—in an intuitive, lightweight Java program. It’s perfect for learning GUI application structure, persistence mechanisms, and basic financial metrics. :contentReference[oaicite:1]{index=1}

---

## ✅ Features

- 🧮 Add, edit, and delete **incomes** and **expenses**  
- 📊 View **dashboard summary**: total balance, total income, total expense  
- 💾 Persistent storage using **H2 embedded database** or local file  
- 📑 Option to **generate reports** in CSV or plain-text format  
- 🏦 **Categorize transactions** (e.g., food, rent, salary)  
- 🧮 **Built-in calculator** for quick calculations

---

## 🛠️ Tech Stack & Dependencies

- 🟩 **Java 8+** (Swing UI for GUI components)  
- 💾 **H2 Database** for embedded persistence  
- 🔐 **JBCrypt** (optional) for password hashing  
- 🧩 CSV export capability via Java I/O

---

## 🗂️ Database & Structure

The embedded H2 database (or local file) uses tables such as:

- `USER_ACCOUNT` – stores login credentials  
- `INCOME` – amount, date, description, category  
- `EXPENSE` – amount, date, description, category  
- `CATEGORY` – list of expense/income categories  
- `TRANSACTION` (optional unified table)  

Transactions are loaded at runtime and saved automatically on add/edit/delete.

---

## ⚙️ Installation & Setup

```bash
git clone https://github.com/MisaghMomeniB/Financial-Tracking-Java.git
cd Financial-Tracking-Java
````

To compile and run:

```bash
javac -cp lib/* -d bin src/com/financetracker/*.java
java -cp "bin:lib/*" com.financetracker.MainApp
```

*(On Windows replace `:` with `;` in classpath.)*

---

## 🚀 Usage

* **Login/Register** on startup
* Use GUI forms or console prompts to **add/edit/delete** transactions
* View **dashboard summary** of balance, income, and expenses
* Export transaction data to **CSV** or generate reports

---

## 📁 Code Structure

```
Financial-Tracking-Java/
├── src/
│   └── com/financetracker/
│       ├── model/       # Entity classes (Transaction, User)
│       ├── dao/         # Data access objects (DB logic)
│       ├── ui/          # GUI (Swing) and Console classes
│       └── MainApp.java # App entrypoint
├── lib/                 # External JARs (H2, JBCrypt)
├── bin/                 # Compiled .class files
└── README.md            # This file
```

---

## ⚠️ Future Enhancements

* 🛡️ Add **user authentication & encryption**
* 📱 Extend UI to **JavaFX or Swing UI improvements**
* 📈 Include **visual charts** (e.g., JavaFX, JFreeChart)
* ☁️ Export data to **PDF**, Excel, or integrate cloud sync
* 🔄 Batch import/export of transactions
* 🧪 Add **unit tests** (JUnit) and error validation

---

## 🤝 Contributing

All contributions welcome! Please:

1. Fork the repo
2. Create a feature branch (`feature/...`)
3. Commit changes with clear messages
4. Submit a Pull Request explaining your additions

---

## 📄 License

This project is licensed under the **MIT License** — see [LICENSE](LICENSE) for details.
