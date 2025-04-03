package se.lexicon.data;

import se.lexicon.model.Product;

public class VendingMachineImpl implements IVendingMachine {

    //fields
    private Product[] products;
    private int depositPool;
    private static final int[] acceptedAmounts = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000}; //array with acceptable amounts for deposit


    //getters and setters
    public void setProducts(Product[] products) {
        this.products = products;
    }

    public void setDepositPool(int depositPool) {
        this.depositPool = depositPool;
    }

    //other methods
    @Override
    public void addCurrency(int amount) {
        if(isValidAmount(amount)){
            setDepositPool(amount);
        }else {
            System.out.println("Not an acceptable amount");
        }
    }

    //check if amount is valid
    private boolean isValidAmount(int amount) {
        for (int a : acceptedAmounts) {
            if (a == amount) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public Product request() {
        return null;
    }

    @Override
    public int endSession() {
        int temp = depositPool;
        setDepositPool(0);
        return temp;
    }

    @Override
    public String getDescription(int id) {
        Product product = searchProductMatchingId(id);
        if(product != null) {
            return product.examine();
        }
        return "Product not found";
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

        @Override
        public String[] getProducts() { // Returns String array where each String contains the Product’s id, name and price
        //String[] productInfo = {products[0].use(), products[1].use(), products[2].use(), products[3].use()};
            String[] productInfo = new String[4];
            for(int i = 0; i < products.length ; i++){
            productInfo[i] = products[i].use();
        }

        return productInfo;
        }

}
