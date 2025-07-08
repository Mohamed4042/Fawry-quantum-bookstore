package Inventorys;

import models.Book;

import java.util.*;

public class BookInventory {
    private List<Book> inventory = new ArrayList<>();

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Quantum book store: Cannot add null book to inventory");
        }
        inventory.add(book);
    }

    public Book removeBook(String isbn) {
        Iterator<Book> iterator = inventory.iterator();
        while (iterator.hasNext()) {
            Book b = iterator.next();
            if (b.getISBN().equals(isbn)) {
                iterator.remove();
                return b;
            }
        }
        return null;
    }

    public List<Book> removeOutdatedBooks(int currentYear, int maxAge) {
        List<Book> removed = new ArrayList<>();
        Iterator<Book> it = inventory.iterator();
        while (it.hasNext()) {
            Book b = it.next();
            if (currentYear - b.getYear() > maxAge) {
                removed.add(b);
                it.remove();
            }
        }
        return removed;
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        for (Book book : inventory) {
            if (book.getISBN().equals(isbn)) {
                return book.buy(quantity, email, address);
            }
        }
        throw new IllegalArgumentException("Quantum book store: Book with ISBN " + isbn + " not found");
    }
}
