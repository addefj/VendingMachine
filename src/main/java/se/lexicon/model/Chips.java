package se.lexicon.model;

public class Chips extends Product {
//todo: add error handling
    //fields
    private boolean ribbed;
    private ChipsFlavour chipsFlavour;

    //constructor
    public Chips(double price, String productName, boolean ribbed, ChipsFlavour chipsFlavour) {
        super(price, productName);
        setRibbed(ribbed);
        setChipsFlavour(chipsFlavour);
    }

    //getters and setters
    public boolean isRibbed() {
        return ribbed;
    }

    public void setRibbed(boolean ribbed) {
        this.ribbed = ribbed;
    }

    public ChipsFlavour getChipsFlavour() {
        return chipsFlavour;
    }

    public void setChipsFlavour(ChipsFlavour chipsFlavour) {
        this.chipsFlavour = chipsFlavour;
    }

    //other methods
    @Override
    public String examine() {
        return "Id: " + getId() + "\nName: " + getProductName() + "\nFlavour: " + getChipsFlavour() + "\nPrice: " + getPrice()
                + "\nRibbed: " + isRibbed();
    }

    @Override
    public String use() {
        return "Id: " + getId() + "\nName: " + getProductName() + "\nFlavour: " + getChipsFlavour() +"\nPrice: " + getPrice();
    }


}
