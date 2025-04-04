package se.lexicon;

import se.lexicon.data.VendingMachineImpl;
import se.lexicon.model.*;

import java.util.Scanner;

public class UI {

    public static void main(String[] args) {


        boolean running = true;
        int id;

        //initiating product array filled with products
        Product[] products = {
                new Soda(20, "Captain's Fizzy Soda", true, SodaFlavour.ORANGE),
                new Chips(30, "Crispy's Crispies", false, ChipsFlavour.SALTED),
                new SnackBar(15, "Snack that! Chocolate", BarFlavour.CHOCOLATE, true, NutType.PEANUT),
                new SnackBar(15, "Snack that! Caramel", BarFlavour.CARAMEL, false)
        };

        VendingMachineImpl metroV = new VendingMachineImpl(products); //create vending machine object
        Scanner userInput = new Scanner(System.in); //create scanner object

        System.out.println();
        System.out.println("Welcome to my vending machine"); //display welcoming message

        while(running) {

            //display main menu
            System.out.println();
            System.out.println("========  Main menu  =========");
            System.out.println("Current balance: " + metroV.getBalance() + " SEK");
            System.out.println("1. Display available products");
            System.out.println("2. Examine a product");
            System.out.println("3. Add currency");
            System.out.println("4. Buy a product");
            System.out.println("5. End session and return change");
            System.out.println("6. Exit");
            System.out.println("------------------------------");
            System.out.println("Choose an option: ");

            int option = userInput.nextInt(); //read user input

            switch (option){
                case 1: //display all products
                String[] items = metroV.getProducts();
                    System.out.println("==  List of available items  ==");
                for(String item: items){
                    System.out.println(item);
                    System.out.println("--------------------------------");
                }
                    break;

                case 2: //examine product
                    System.out.println("Enter id of product to examine");
                    id  = userInput.nextInt();
                    String description = metroV.getDescription(id);
                    System.out.println("--------------------------------");
                    System.out.println(description);
                    break;

                case 3: //add currency
                    System.out.println("You chose to add currency");
                    System.out.println("Valid denominations are (1, 2, 5, 10, 20, 50, 100, 200, 500, 1000)");
                    System.out.println("Enter amount of SEK to add:");

                    int amount  = userInput.nextInt();
                    metroV.addCurrency(amount);

                    System.out.println("You added " + amount + " SEK");
                    break;

                case 4: //buy product
                    System.out.println("Enter id of product to buy");
                    id = userInput.nextInt();
                    Product product = metroV.request(id);
                    System.out.println("You bought:\n" + product.getProductName());
                    System.out.println("It was delicious");
                    break;

                case 5: //end session (return change)
                    int change = metroV.endSession();
                    System.out.println("Session ended. Returned change: " + change + " SEK");
                    break;

                case 6: //exit (return change)
                    if(metroV.getBalance() > 0){
                        int changeOnExit = metroV.endSession();
                        System.out.println("You chose to exit. Returned change: " + changeOnExit + " SEK");
                    }
                    System.out.println("Welcome back another time!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option, Try again!");
                    break;

            }
        }
    }
}
