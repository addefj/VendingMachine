package se.lexicon.data;

import se.lexicon.model.Product;

public interface IVendingMachine {

    void addCurrency(int amount);
    int getBalance();
    Product request();
    int endSession();
    String getDescription(int id);
    String[] getProducts();

}
