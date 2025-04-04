package se.lexicon.model;

public class SnackBar extends Product {

    //fields
    private final boolean nuts;
    private final BarFlavour barFlavour;
    private NutType nutType;

    //constructor
    public SnackBar(double price, String productName, BarFlavour barFlavour, boolean nuts, NutType nutType) {
        this(price, productName, barFlavour, nuts);
        this.nutType = nutType;
    }

    public SnackBar(double price, String productName, BarFlavour barFlavour, boolean nuts){
        super(price, productName);
        this.barFlavour = barFlavour;
        this.nuts = nuts;
    }

    //getters and setters
    public boolean isNuts() {
        return nuts;
    }

    public BarFlavour getBarFlavour() {
        return barFlavour;
    }

    public NutType getNutType() {
        return nutType;
    }


    //other methods
    @Override
    public String examine() {
        String nutInfo = "No nuts";
        if(isNuts()){
            nutInfo = String.valueOf(getNutType());
        }
        return "Id: " + getId() + "\nName: " + getProductName() + "\nFlavour: " + getBarFlavour() +"\nPrice: " + getPrice()
                + "\nContains Nuts: " + isNuts() + "\nType of nuts: " + nutInfo;
    }

    @Override
    public String use() {
        return "Id: " + getId() + "\nName: " + getProductName() + "\nPrice: " + getPrice();
    }
}
