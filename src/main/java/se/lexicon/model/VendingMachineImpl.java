package se.lexicon.model;

public class VendingMachineImpl implements IVendingMachine {

    //fields
    private Product[] products;
    private int depositPool;


    //other methods
    @Override
    public void addCurrency(double amount) {

    }

    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public Product request() {
        return null;
    }

    @Override
    public int endSession() {
        return 0;
    }

    @Override
    public String getDescription(int id) {
        return "";
    }

    @Override
    public String[] getProducts() {
        return new String[0];
    }
}
