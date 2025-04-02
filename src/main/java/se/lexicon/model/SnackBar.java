package se.lexicon.model;

public class SnackBar extends Product {

    //fields
    private boolean nuts;
    private BarFlavour barFlavour;
    private NutType nutType;

    //constructor
    public SnackBar(double price, String productName, BarFlavour barFlavour, boolean nuts, NutType nutType) {
        this(price, productName, barFlavour, nuts);
        setNutType(nutType);
    }

    public SnackBar(double price, String productName, BarFlavour barFlavour, boolean nuts){
        super(price, productName);
        setBarFlavour(barFlavour);
        setNuts(nuts);
    }

    //getters and setters
    public boolean isNuts() {
        return nuts;
    }

    public void setNuts(boolean nuts) {
        this.nuts = nuts;
    }

    public BarFlavour getBarFlavour() {
        return barFlavour;
    }

    public void setBarFlavour(BarFlavour barFlavour) {
        this.barFlavour = barFlavour;
    }

    public NutType getNutType() {
        return nutType;
    }

    public void setNutType(NutType nutType) {
        this.nutType = nutType;
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
        return "Id: " + getId() + "\nName: " + getProductName() + "\nFlavour: " + getBarFlavour() + "\nPrice: " + getPrice();
    }
}
