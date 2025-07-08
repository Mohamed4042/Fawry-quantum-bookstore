package models;

import services.ShippingService;

public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, String author, int year, double price, int stock) {
        super(isbn, title, author, year, price);
        this.stock = stock;
    }

    @Override
    public double buy(int quantity, String email, String address) {
        if (quantity > stock) {
            throw new IllegalArgumentException("Quantum book store: Not enough stock for ISBN " + isbn);
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantum book store: Quantity must be greater than 0");
        }
        stock -= quantity;
        ShippingService.send(address);
        return quantity * price;
    }
}
