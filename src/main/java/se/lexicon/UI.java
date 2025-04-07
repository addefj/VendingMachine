package se.lexicon;

import se.lexicon.data.VendingMachineImpl;
import se.lexicon.model.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    // ANSI color codes
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";

    public static void main(String[] args) {

        boolean running = true;
        int id; //stores id entered by user
        int option; //stores menu option entered by user

        //initiating product array filled with products
        Product[] products = {
                new Soda(20, "Captain's Fizzy Soda", true, SodaFlavour.ORANGE),
                new Soda(20, "Captain's Raspberry soda", false, SodaFlavour.RASPBERRY),
                new Chips(30, "Crispy's Crispies", false, ChipsFlavour.SALTED),
                new Chips(30, "Crispy's Waves", true, ChipsFlavour.BARBEQUE),
                new SnackBar(15, "Snack that! Chocolate", BarFlavour.CHOCOLATE, true, NutType.PEANUT),
                new SnackBar(15, "Snack that! Caramel", BarFlavour.CARAMEL, false)
        };

        VendingMachineImpl metroV = new VendingMachineImpl(products); //create vending machine object
        Scanner userInput = new Scanner(System.in); //create scanner object

        System.out.println();
        System.out.println("Welcome to my vending machine"); //display welcoming message

        while (running) {

            //display main menu
            System.out.println();
            System.out.println(GREEN + "========  Main menu  =========" + RESET);
            System.out.println(BLUE + "Current balance: " + metroV.getBalance() + " SEK" + RESET);
            System.out.println(GREEN + "1." + RESET + " Display available products");
            System.out.println(GREEN + "2." + RESET + " Examine a product");
            System.out.println(GREEN + "3." + RESET + " Add currency");
            System.out.println(GREEN + "4." + RESET + " Buy a product");
            System.out.println(GREEN + "5." + RESET + " End session and return change");
            System.out.println(RED + "6. Exit" + RESET);
            System.out.println(GREEN + "------------------------------" + RESET);
            System.out.println(CYAN + "Choose an option: " + RESET);

            try {
                option = userInput.nextInt(); //read user input
            } catch (InputMismatchException e) {
                System.out.println(RED + "Invalid input. Enter an integer from 1-6" + RESET);
                userInput.next(); //clears scanner buffer
                continue;
            }

            switch (option) {
                case 1: //display all products
                    String[] items = metroV.getProducts();
                    System.out.println(GREEN + "==  List of available items  ==" + RESET);
                    for (String item : items) {
                        System.out.println(item);
                        System.out.println(GREEN + "--------------------------------" + RESET);
                    }
                    break;

                case 2: //examine product
                    System.out.println(CYAN + "Enter id of product to examine:" + RESET);
                    id = userInput.nextInt();
                    String description = metroV.getDescription(id);
                    System.out.println(GREEN + "--------------------------------" + RESET);
                    System.out.println(description);
                    break;

                case 3: //add currency
                    System.out.println(GREEN + "You chose to add currency" + RESET);
                    System.out.println(GREEN + "Valid denominations are (1, 2, 5, 10, 20, 50, 100, 200, 500, 1000)" + RESET);
                    System.out.println(CYAN + "Enter amount of SEK to add:" + RESET);

                    int amount = userInput.nextInt();
                    metroV.addCurrency(amount);

                    System.out.println(GREEN + "You added " + amount + " SEK" + RESET);
                    break;

                case 4: //buy product
                    System.out.println(GREEN + "Enter id of product to buy" + RESET);
                    id = userInput.nextInt();
                    Product product = metroV.request(id);
                    System.out.println(GREEN + "You bought:\n" + RESET + product.getProductName());
                    System.out.println(CYAN + "It was delicious" + RESET);
                    break;

                case 5: //end session (return change)
                    int change = metroV.endSession();
                    System.out.println(GREEN + "Session ended. Returned change: " + change + " SEK" + RESET);
                    break;

                case 6: //exit (return change)
                    if (metroV.getBalance() > 0) {
                        int changeOnExit = metroV.endSession();
                        System.out.println(GREEN + "You chose to exit. Returned change: " + changeOnExit + " SEK" + RESET);
                    }
                    System.out.println(GREEN + "Welcome back another time!" + RESET);
                    running = false;
                    break;

                default:
                    System.out.println(RED + "Invalid option, enter an integer from 1-6 " + RESET);
                    break;

            }
        }
    }
}
