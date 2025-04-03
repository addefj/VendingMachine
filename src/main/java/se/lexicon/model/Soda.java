package se.lexicon.model;

public class Soda extends Product{
    //todo: add error handling
    //fields
    private final boolean carbonated;
    private final SodaFlavour sodaFlavour;

    //constructor
    public Soda(double price, String productName, boolean carbonated, SodaFlavour sodaFlavour) {
        super(price, productName);
        this.carbonated = carbonated;
        this.sodaFlavour = sodaFlavour;
    }

    //getters and setters
    public boolean isCarbonated() {
        return carbonated;
    }

    public SodaFlavour getSodaFlavour() {
        return sodaFlavour;
    }

    //other methods
    @Override
    public String examine() {
        return "Id: " + getId() + "\nName: " + getProductName() + "\nFlavour: " + getSodaFlavour() + "\nPrice: " + getPrice()
                + "\nCarbonated: " + isCarbonated();
    }

    @Override
    public String use() {
        return "Id: " + getId() + "\nName: " + getProductName() + "\nPrice: " + getPrice();
    }

}
