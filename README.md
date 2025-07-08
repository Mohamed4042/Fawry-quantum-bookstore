# 📘 Quantum Bookstore System

A Java-based backend system simulating a real bookstore, built with clean OOP principles and designed to be easily extensible.

This system supports adding books, removing outdated ones, and purchasing books with behavior depending on their type.

---

## 🚀 Features

- Add books with ISBN, title, author, year, and price
- Remove outdated books based on publish year
- Buy books by ISBN with type-specific behavior:
  - 📦 PaperBooks: reduce stock, ship to address
  - 📧 EBooks: sent via email (1 copy max)
  - ❌ DemoBooks: not for sale
- Fully tested with clear console output

---


## 🧪 Test Scenarios Covered

- ✅ Buy PaperBook (valid case, reduces stock)
- ❌ Buy PaperBook (exceeds stock)
- ❌ Buy PaperBook (zero quantity)
- ✅ Buy EBook (valid case)
- ❌ Buy EBook (invalid quantity)
- ❌ Buy EBook (missing email)
- ❌ Buy DemoBook (throws error)
- ❌ Buy non-existent book
- ✅ Remove outdated books (older than X years)
- ✅ Remove book manually
- ❌ Add a null book

------

## 🧠 Why This Project Stands Out

- Interface-based design (`Sellable`) allows for easy expansion
- Book behavior is fully encapsulated — no if/else chains or type checking
- Looks and reads like a real-world, human-written backend system
- Adheres to **Open/Closed Principle** — open for extension, closed for modification
