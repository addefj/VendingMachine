package se.lexicon;

import se.lexicon.model.*;

public class Main {
    public static void main(String[] args) {

        Soda drink1 = new Soda(2.99, "Soda", true, SodaFlavour.ORANGE);
        Chips chips1 = new Chips( 1.99, "Chips" ,false, ChipsFlavour.SALTED);
        SnackBar snackBar1 = new SnackBar( 1.49, "Snackbar", BarFlavour.CHOCOLATE, true, NutType.PEANUT );
        SnackBar snackBar2 = new SnackBar( 1.49, "Snackbar", BarFlavour.CARAMEL, false);

        //testing the use method
        System.out.println("Use method");
        System.out.println(drink1.use());
        System.out.println("---------------------");
        System.out.println(chips1.use());
        System.out.println("---------------------");
        System.out.println(snackBar1.use());
        System.out.println("---------------------");
        System.out.println(snackBar2.use());

        System.out.println("=========================");

        //testing the examine method
        System.out.println("Examine method");
        System.out.println(drink1.examine());
        System.out.println("---------------------");
        System.out.println(chips1.examine());
        System.out.println("---------------------");
        System.out.println(snackBar1.examine());
        System.out.println("---------------------");
        System.out.println(snackBar2.examine());

    }
}