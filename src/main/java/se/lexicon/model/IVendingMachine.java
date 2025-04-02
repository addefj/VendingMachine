package se.lexicon.model;

public interface IVendingMachine {

    void addCurrency(double amount);
    double getBalance();
    Product request();
    int endSession();
    String getDescription(int id);
    String[] getProducts();

}
