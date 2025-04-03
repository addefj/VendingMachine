package se.lexicon.model;

public class Chips extends Product {
//todo: add error handling
    //fields
    private final boolean ribbed;
    private final ChipsFlavour chipsFlavour;

    //constructor
    public Chips(double price, String productName, boolean ribbed, ChipsFlavour chipsFlavour) {
        super(price, productName);
        this.ribbed = ribbed;
        this.chipsFlavour = chipsFlavour;
    }

    //getters and setters
    public boolean isRibbed() {
        return ribbed;
    }

    public ChipsFlavour getChipsFlavour() {
        return chipsFlavour;
    }

    //other methods
    @Override
    public String examine() {
        return "Id: " + getId() + "\nName: " + getProductName() + "\nFlavour: " + getChipsFlavour() + "\nPrice: " + getPrice()
                + "\nRibbed: " + isRibbed();
    }


    @Override
    public String use() {
        return "Id: " + getId() + "\nName: " + getProductName() +"\nPrice: " + getPrice();
    }


}
