package interfaces;

public interface Sellable {
    double buy(int quantity, String email, String address);
    String getISBN();
    String getTitle();
    int getYear();
}
