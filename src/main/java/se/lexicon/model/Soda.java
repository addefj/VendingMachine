package se.lexicon.model;

public class Soda extends Product{
    //todo: add error handling
    //fields
    private boolean carbonated;
    private SodaFlavour sodaFlavour;

    //constructor
    public Soda(double price, String productName, boolean carbonated, SodaFlavour sodaFlavour) {
        super(price, productName);
        setCarbonated(carbonated);
        setSodaFlavour(sodaFlavour);
    }

    //getters and setters
    public boolean isCarbonated() {
        return carbonated;
    }

    public void setCarbonated(boolean carbonated) {
        this.carbonated = carbonated;
    }

    public SodaFlavour getSodaFlavour() {
        return sodaFlavour;
    }

    public void setSodaFlavour(SodaFlavour sodaFlavour) {
        this.sodaFlavour = sodaFlavour;
    }

    //other methods
    @Override
    public String examine() {
        return "Id: " + getId() + "\nName: " + getProductName() + "\nFlavour: " + getSodaFlavour() + "\nPrice: " + getPrice()
                + "\nCarbonated: " + isCarbonated();
    }

    @Override
    public String use() {
        return "Id: " + getId() + "\nName: " + getProductName() + "\nFlavour: " + getSodaFlavour() + "\nPrice: " + getPrice();
    }

}
