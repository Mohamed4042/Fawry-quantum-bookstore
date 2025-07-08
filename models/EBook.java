package models;

import services.MailService;

public class EBook extends Book {
    private String filetype;

    public EBook(String isbn, String title, String author, int year, double price, String filetype) {
        super(isbn, title, author, year, price);
        this.filetype = filetype;
    }

    @Override
    public double buy(int quantity, String email, String address) {
        if (quantity != 1) {
            throw new IllegalArgumentException("Quantum book store: EBooks can only be bought one at a time");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Quantum book store: Email is required to buy an EBook");
        }
        MailService.send(email);
        return price;
    }
}
