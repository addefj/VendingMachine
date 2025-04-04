package se.lexicon;

import se.lexicon.data.VendingMachineImpl;
import se.lexicon.model.*;

public class Main {
    public static void main(String[] args) {

        //initiating product array filled with products
        Product[] products = {
                new Soda(20, "Captain's Fizzy Soda", true, SodaFlavour.ORANGE),
                new Chips( 30, "Crispy's Crispies" ,false, ChipsFlavour.SALTED),
                new SnackBar( 15, "Snack that!", BarFlavour.CHOCOLATE, true, NutType.PEANUT ),
                new SnackBar( 15, "Snack that!", BarFlavour.CARAMEL, false)
        };

        //creating
        VendingMachineImpl metroV = new VendingMachineImpl(products);

        //testing add currency method vid valid amount
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
        //System.out.println(Arrays.toString(metroV.getProducts()));

        for (String string : metroV.getProducts()) {
            System.out.println(string);
            System.out.println("-----------------------");
        }

        //add currency before buying a product
        metroV.addCurrency(50);
        System.out.println(metroV.getBalance());

        metroV.request(2);


        //check remaining in deposit pool
        System.out.println(metroV.getBalance());


    }
}