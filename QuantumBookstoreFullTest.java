import models.*;
import Inventorys.BookInventory;

import java.util.List;


public class QuantumBookstoreFullTest {
    public static void main(String[] args) {
        BookInventory store = new BookInventory();

        // -------- Add Books --------
        store.addBook(new PaperBook("ISBN1", "Paper Book 1", "Author A", 2015, 120.0, 5));
        store.addBook(new EBook("ISBN2", "EBook 1", "Author B", 2020, 80.0, ".pdf"));
        store.addBook(new DemoBook("ISBN3", "Demo Book", "Author C", 2012));

        System.out.println("Quantum book store: --- TESTS ---");

        // -------- Buy PaperBook (Valid) --------
        try {
            double paid = store.buyBook("ISBN1", 2, "user@mail.com", "123 Main St");
            System.out.println("Quantum book store: Paid = " + paid); // should be 240
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // -------- Buy PaperBook (Insufficient Stock) --------
        try {
            store.buyBook("ISBN1", 10, "user@mail.com", "123 Main St");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // -------- Buy PaperBook (Zero quantity) --------
        try {
            store.buyBook("ISBN1", 0, "user@mail.com", "123 Main St");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // -------- Buy EBook (Valid) --------
        try {
            double paid = store.buyBook("ISBN2", 1, "user@mail.com", "-");
            System.out.println("Quantum book store: Paid = " + paid); // should be 80
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // -------- Buy EBook (More than 1) --------
        try {
            store.buyBook("ISBN2", 2, "user@mail.com", "-");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // -------- Buy EBook (Missing Email) --------
        try {
            store.buyBook("ISBN2", 1, "", "-");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // -------- Buy DemoBook (Not for sale) --------
        try {
            store.buyBook("ISBN3", 1, "-", "-");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // -------- Buy Book that Doesn't Exist --------
        try {
            store.buyBook("ISBN-NOTFOUND", 1, "user@mail.com", "addr");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // -------- Remove outdated books --------
        List<Book> removed = store.removeOutdatedBooks(2025, 10);
        for (Book b : removed) {
            System.out.println("Quantum book store: Removed outdated book: " + b.getTitle());
        }

        // -------- Remove Book Manually --------
        Book removedBook = store.removeBook("ISBN1");
        if (removedBook != null) {
            System.out.println("Quantum book store: Removed manually: " + removedBook.getTitle());
        }

        // -------- Add and Buy another PaperBook --------
        store.addBook(new PaperBook("ISBN4", "New Paper", "Author D", 2023, 150.0, 3));
        try {
            double paid = store.buyBook("ISBN4", 1, "mohamed@mail.com", "Address");
            System.out.println("Quantum book store: Paid = " + paid);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // -------- Add Null Book --------
        try {
            store.addBook(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Quantum book store: --- END TESTS ---");
    }
}
