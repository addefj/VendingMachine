package se.lexicon.model;

public abstract class Product {
    //todo: add error handling
    //fields
    private static int sequencer = 0;
    private int id;
    private double price;
    private String productName;

    //constructor
    public Product(double price, String productName) {
        id = getNextId();
        setPrice(price);
        setProductName(productName);
    }

    public int getNextId(){
    return ++sequencer;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    //methods
    public abstract String examine();

    public abstract String use();

}
