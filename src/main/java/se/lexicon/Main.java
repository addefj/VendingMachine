package se.lexicon;

import se.lexicon.data.VendingMachineImpl;
import se.lexicon.model.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Soda drink1 = new Soda(20, "Captain's Fizzy Soda", true, SodaFlavour.ORANGE);
        Chips chips1 = new Chips( 30, "Crispy's Crispies" ,false, ChipsFlavour.SALTED);
        SnackBar snackBar1 = new SnackBar( 15, "Snack that!", BarFlavour.CHOCOLATE, true, NutType.PEANUT );
        SnackBar snackBar2 = new SnackBar( 15, "Snack that!", BarFlavour.CARAMEL, false);

        Product[] product = {drink1, chips1, snackBar1, snackBar2};
        VendingMachineImpl metroV = new VendingMachineImpl();
        metroV.setProducts(product);

        //testing add currency method
        metroV.addCurrency(3); //incorrect amount
        metroV.addCurrency(100); //correct amount

        System.out.println("---------------------");

        //testing get balance method
        System.out.println(metroV.getBalance());

        System.out.println("---------------------");

        //testing end session method
        System.out.println("Session ended, returned change: " + metroV.endSession() + ", Deposit: " + metroV.getBalance());

        System.out.println("---------------------");

        //testing get description method
        System.out.println(metroV.getDescription(2));

        System.out.println("---------------------");

        //testing get products method
        System.out.println(Arrays.toString(metroV.getProducts()));



        /*
        Soda drink1 = new Soda(2.99, "Captain's Fizzy Soda", true, SodaFlavour.ORANGE);
        Chips chips1 = new Chips( 1.99, "Crispy's Cripies" ,false, ChipsFlavour.SALTED);
        SnackBar snackBar1 = new SnackBar( 1.49, "Snack that!", BarFlavour.CHOCOLATE, true, NutType.PEANUT );
        SnackBar snackBar2 = new SnackBar( 1.49, "Snack that!", BarFlavour.CARAMEL, false);

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

         */

    }
}