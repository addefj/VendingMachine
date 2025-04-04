package se.lexicon.data;

import se.lexicon.model.Product;

public class VendingMachineImpl implements IVendingMachine {

    //fields
    public final Product[] products;
    private int depositPool;
    private static final int[] validAmounts = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000}; //array with valid amounts for deposit

    //constructor
    public VendingMachineImpl(Product[] products) {
        this.products = products;
    }

    //methods
    //add the input amount to the deposit pool if able
    @Override
    public void addCurrency(int amount) {
        if (isValidAmount(amount)) {
            depositPool = amount;
        } else {
            throw new IllegalArgumentException("Not a valid denomination");
        }
    }

    //check if the input amount is valid
    private boolean isValidAmount(int amount) {
        for (int v : validAmounts) {
            if (v == amount) {
                return true;
            }
        }
        return false;
    }

    //returns the value of current deposit pool
    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public Product request(int id) {
        Product reqProduct = searchProductMatchingId(id);
        if(reqProduct == null) {
            throw new IllegalArgumentException("Product with id: " + id + " was not found");
        }
        if(reqProduct.getPrice() <= getBalance()){
            depositPool -= (int) reqProduct.getPrice();
            return reqProduct;
        }
        throw new IllegalArgumentException("Product with id: " + id + " was too expensive");
    }

    //resets deposit pool to 0, and returns remaining change
    @Override
    public int endSession() {
        int temp = depositPool;
        depositPool = 0;
        return temp;
    }

    //returns a detailed description of the requested product
    @Override
    public String getDescription(int id) {
        Product product = searchProductMatchingId(id);
        if (product != null) {
            return product.examine();
        }
        throw new IllegalArgumentException("Product with id: " + id + " was not found");
    }

    //method for finding the index of the requested product id.
    public Product searchProductMatchingId(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product; //returns product with matching id.
            }
        }
        return null;
    }

    //returns an array with short description of available products
    @Override
    public String[] getProducts() { // Returns String array where each String contains the Product’s id, name and price

        String[] productInfo = new String[products.length];
        for (int i = 0; i < products.length; i++) {
            productInfo[i] = products[i].use();
        }
        return productInfo;
    }

}
