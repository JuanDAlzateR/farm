/* Last update 07/Aug/2025
I created packages, so the classes and files would be a little more organized
The interfaces could be improved, I think Buy it's well implemented, but the
other interfaces just check if the classes have the respective methods.

I hope to implement a user menu.Menu using Scanner
(a menu.Menu that is useful and not to complicated)

I'll continue working on the code, so far I haven't implemented all
changes and suggestions (from the last time), but still I wanted to
share the progress so far.
 */

import animals.*;
import crops.*;
import crops.Farm2;
import farm.*;
import menu.*;


import java.util.Scanner;
//TIP To <b>interfaces.Run</b> code, press <shortcut actionId="interfaces.Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        Scanner scanner = new Scanner(System.in);


//      TreeMenu allMenus = new TreeMenu();
//      NodeMenu mainMenu=allMenus.getRoot();


        AllMenus menu = new AllMenus();
        Farm farm =new Farm();
        scanner=menu.getScanner();
        menu.getMainMenu().run();

        scanner.close();

    }

    public static void mainMenu(Scanner scanner){
        int option;
        while(true){
            System.out.println("== Main menu.Menu ==");
            System.out.println("Choose one option:");
            System.out.println("1) Create/Choose Farm");
            System.out.println("2) Admin bank accounts:");
            System.out.println("3) Admin Farm:");
            System.out.println("0) Quit or Exit");
            System.out.println("Write the number of the chosen option:");
            option= scanner.nextInt();

            switch(option){
                case 1:
                    System.out.println("1)");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    adminFarmMenu(scanner);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, please try again");
            }
        }
    }

    public static void adminFarmMenu(Scanner scanner){
        int option;
        boolean activeMenu=true;
        while(activeMenu){
            System.out.println("== Admin Farm menu.Menu ==");
            System.out.println("1) Buy items or animals");
            System.out.println("2) Admin Crops");
            System.out.println("3) Sell products");
            System.out.println("0) Back to Main menu.Menu");
            System.out.println("Write the number of the chosen option:");
            option= scanner.nextInt();

            switch(option){
                case 1:
                    System.out.println("1)");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 0:
                    activeMenu=false;
                    break;
                default:
                    System.out.println("Invalid option, please try again");
            }
        }
    }

    public static void example(){
        farm.Farm farm = new farm.Farm();
        BankAccount bankAccount = new BankAccount("Bank", 1234, 2000F, "Income");
        FarmAccount account = new FarmAccount(farm,bankAccount);
        account.display();

        Tool tool =new Tool("Pitchfork",40);
        account.buyItem(tool);
        System.out.println(tool);
        System.out.println("-------");

        Farm2 carrotSeeds = new Farm2("Carrots", 100,0.1F);
        account.buyItem(carrotSeeds);

        farm.sowAllGrains();
        System.out.println("Date:" + farm.getDate() + " carrots sown");
        farm.passTime(30);

        Farm2 cornSeed = new Farm2("Corn", 200, 0.2F);
        Farm2 riceSeed = new Farm2("Rice", 300, 0.1F);
        account.buyItem(cornSeed);
        account.buyItem(riceSeed);
        farm.sowAllGrains();
        System.out.println("Date:" + farm.getDate() + " corn and rice sown");
        System.out.println("-------");

        farm.passTime(10);
        farm.displayCrops();

        farm.passTime(70);
        farm.displayCrops();

        farm.harvestAllCrops();
        System.out.println("HARVEST");
        farm.displayCrops();
        farm.displayProducts();

        farm.passTime(20);
        farm.harvestAllCrops();
        System.out.println("HARVEST");
        farm.displayCrops();
        farm.displayProducts();

        System.out.println("SELL PRODUCTS");
        System.out.println("30 carrots sold.");
        Product product = farm.getProducts().get(0);
        product.setSellPrice(1F);
        float cash = farm.sell(product, 30);
        bankAccount.addBalance(cash);
        bankAccount.shortDisplay();
        farm.displayProducts();

        System.out.println("ANIMALS ACQUIRED");
        AnimalFeed chickenFeed = new AnimalFeed("chicken feed", 0.9F, 0.1F, "kg");
        AnimalFeed cowFeed = new AnimalFeed("cattle feed", 1000, 15F, "kg");
        AnimalFood egg = new AnimalFood("egg", 0, 1, "units");
        AnimalFood milk = new AnimalFood("milk", 0, 20, "liters");
        FarmAnimals chickens = new Poultry("chickens", 10, egg, chickenFeed);
        FarmAnimals cows = new Livestock("cows", 2, milk, cowFeed);
        chickens.setPrice(20F);
        cows.setPrice(600F);

        account.buyItem(chickens);
        account.buyItem(cows);
        farm.displayAnimals();

        farm.passTime(5);
        farm.displayAnimals();
        farm.displayProducts();

        farm.passTime(5);
        System.out.println("Date:" + farm.getDate());
        System.out.println(tool);

    }
}