package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);

    // metode i propertiji za kasnije
    static int waterRemaining;
    static int milkRemaining;
    static int beansRemaining;
    static int cupsRemaining;
    static int cashCollected;


    // ovo ce sve ic u klasu coffeeType il nes da pojednostavnim fill i buy opcije
    final static int espWaterNeeded = 250;
    final static int espMilkNeeded = 0;
    final static int espBeansNeeded = 16;
    final static int espCost = 4;

    final static int latteWaterNeeded = 350;
    final static int latteMilkNeeded = 75;
    final static int latteBeansNeeded = 20;
    final static int latteCost = 7;

    final static int capuWaterNeeded = 200;
    final static int capuMilkNeeded = 100;
    final static int capuBeansNeeded = 12;
    final static int capuCost = 6;


    static String takeMenuChoice() {
        System.out.println("\nWrite action (buy, fill, take): ");
        return scanner.nextLine();
    }

    static void init() {
        waterRemaining = 400;
        milkRemaining = 540;
        beansRemaining = 120;
        cupsRemaining = 9;
        cashCollected = 550;
    }

    static void showReserves() {
        System.out.println("The coffee machine has:\n" +
                waterRemaining + " ml of water\n" +
                milkRemaining + " ml of milk\n" +
                beansRemaining + " g of coffee beans\n" +
                cupsRemaining + " disposable cups\n" +
                "$" + cashCollected + " of money");

    }

    static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int choice = scanner.nextInt();
        boolean hasEnough = true;
        if (choice == 1) {
            if (waterRemaining < espWaterNeeded || milkRemaining < espMilkNeeded || beansRemaining < espBeansNeeded)
                hasEnough = false;
            else {
                waterRemaining = waterRemaining - espWaterNeeded;
                milkRemaining = milkRemaining - espMilkNeeded;
                beansRemaining = beansRemaining - espBeansNeeded;
                cashCollected = cashCollected + espCost;
            }
        } else if (choice == 2) {
            if (waterRemaining < latteWaterNeeded || milkRemaining < latteMilkNeeded || beansRemaining < latteBeansNeeded)
                hasEnough = false;
            else {
                waterRemaining = waterRemaining - latteWaterNeeded;
                milkRemaining = milkRemaining - latteMilkNeeded;
                beansRemaining = beansRemaining - latteBeansNeeded;
                cashCollected = cashCollected + latteCost;
            }
        } else if (choice == 3) {
            if (waterRemaining < capuWaterNeeded || milkRemaining < capuMilkNeeded || beansRemaining < capuBeansNeeded)
                hasEnough = false;
            else {
                waterRemaining = waterRemaining - capuWaterNeeded;
                milkRemaining = milkRemaining - capuMilkNeeded;
                beansRemaining = beansRemaining - capuBeansNeeded;
                cashCollected = cashCollected + capuCost;
            }
        }
        if (hasEnough) cupsRemaining = cupsRemaining - 1;
    }

    static void fill() {
        System.out.println("Write how many ml of water you want to add: ");
        waterRemaining = waterRemaining + scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milkRemaining = milkRemaining + scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        beansRemaining = beansRemaining + scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        cupsRemaining = cupsRemaining + scanner.nextInt();
    }

    static void take() {
        System.out.println("I gave you $" + cashCollected);
        cashCollected = 0;
    }

    static void machineLoop() {
        showReserves();
        String choice = takeMenuChoice();
        if (choice.equals("buy")) buy();
        else if (choice.equals("fill")) fill();
        else if (choice.equals("take")) take();
        /* else {
           invalid input message
        } */
        showReserves();
    }

    public static void main(String[] args) {

        /*System.out.println("Write how many ml of water the coffee machine has:");
        int waterAvail = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milkAvail = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beansAvail = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cupsWanted = scanner.nextInt();

        int waterForCup = 200;
        int milkForCup = 50;
        int beansForCup = 15;

        int cupsByWater = waterAvail / waterForCup;
        int cupsByMilk = milkAvail / milkForCup;
        int cupsByBeans = beansAvail / beansForCup;


        int cupsCanMake = Math.min(cupsByWater, cupsByMilk);
        cupsCanMake = Math.min(cupsCanMake, cupsByBeans);

        if (cupsCanMake >= cupsWanted) {
            int cupsMore = cupsCanMake - cupsWanted;
            System.out.print("Yes, I can make that amount of coffee");
            if (cupsMore > 0) System.out.println(" (and even " + cupsMore + " more than that)");
        }
        else System.out.println("No, I can make only " + cupsCanMake + " cup(s) of coffee");*/

        init();
        machineLoop();

    }

}